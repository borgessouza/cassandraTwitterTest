package br.com.itau.teste.engenheiro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "twitter")
public class TwitterParametrosConfig {

    private String consumeKey;
    private String consumerSecret;
    private String token;
    private String tokenSecret;

    public String getConsumeKey() {
        return consumeKey;
    }

    public void setConsumeKey(String consumeKey) {
        this.consumeKey = consumeKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }
}
