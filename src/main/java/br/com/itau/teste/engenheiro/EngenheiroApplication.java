package br.com.itau.teste.engenheiro;

import br.com.itau.teste.engenheiro.config.TwitterParametrosConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TwitterParametrosConfig.class)
public class EngenheiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(EngenheiroApplication.class, args);
    }

}
