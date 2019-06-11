package br.com.itau.teste.engenheiro.util;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class Twitter4J {


    public static void main(String[] args) {

        System.out.println("Iniciando");
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("fj1ejuZNiEfAKNSZ5lP0fEKys")
                .setOAuthConsumerSecret("5WxHKmiOOF1CYwgHQBUy69VA5vvgg5opw1DgZ38bC7iEPz6EVE")
                .setOAuthAccessToken("88217941-4V99eLj3FEqm2fFz23izJrDx7eJNbfVT63kOb85kg")
                .setOAuthAccessTokenSecret("1jj3W4NHyZY7lwCKLsKQaPBvOaozUodb5NCYnLE0yTMAy");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            Query query = new Query("Neymar");
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }


    }
}
