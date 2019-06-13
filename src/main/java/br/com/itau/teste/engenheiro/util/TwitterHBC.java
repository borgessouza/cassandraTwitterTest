package br.com.itau.teste.engenheiro.util;

import br.com.itau.teste.engenheiro.config.TwitterParametrosConfig;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.event.Event;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class TwitterHBC {


    private TwitterParametrosConfig config;

    private final Authentication authentication;
    private BlockingQueue<String> msgQueue;
    private BlockingQueue<Event> eventQueue;

    private Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);

    private StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();

    public TwitterHBC(TwitterParametrosConfig config) {
        this.config = config;
        msgQueue = new LinkedBlockingQueue<String>(10000);
        eventQueue = new LinkedBlockingQueue<Event>(10000);
        authentication = new OAuth1(config.getConsumeKey(), config.getConsumerSecret(),
                config.getToken(), config.getTokenSecret());
    }

    public Client build(String searchTag) {
        //hosebirdEndpoint.setBackfillCount(50);
        List<String> terms = Collections.singletonList(searchTag);
        hosebirdEndpoint.trackTerms(terms);
        ClientBuilder builder = new ClientBuilder()
                .hosts(hosebirdHosts)
                .authentication(authentication)
                .endpoint(hosebirdEndpoint)
                .processor(new StringDelimitedProcessor(msgQueue))
                .eventMessageQueue(eventQueue);


        return builder.build();
    }


    public String getTwitter() {
        String msg = null;
        try {
            msg = msgQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }

}
