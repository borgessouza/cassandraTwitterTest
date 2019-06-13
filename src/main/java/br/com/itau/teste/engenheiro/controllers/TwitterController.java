package br.com.itau.teste.engenheiro.controllers;

import br.com.itau.teste.engenheiro.VO.TwitterPostsByDateVO;
import br.com.itau.teste.engenheiro.VO.TwitterPostsByLangVO;
import br.com.itau.teste.engenheiro.VO.TwitterUsersVO;
import br.com.itau.teste.engenheiro.model.TwitterUsersByFollowers;
import br.com.itau.teste.engenheiro.services.TwitterCassandraService;
import br.com.itau.teste.engenheiro.services.TwitterProdutoService;
import br.com.itau.teste.engenheiro.util.JsonUtils;
import br.com.itau.teste.engenheiro.util.TwitterHBC;
import com.twitter.hbc.core.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("twitter/")
public class TwitterController {

    private static final int tagSize = 100;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private TwitterHBC twitterHBC;
    @Autowired
    private TwitterProdutoService twitterProdutoService;
    @Autowired
    private TwitterCassandraService twitterCassandraService;
    @Autowired
    private JsonUtils jsonUtils;


    @GetMapping("tagSearch/{tag}")
    public ResponseEntity<String> getTwitter(@PathVariable("tag") String tagSearch) {
        String retorno = new String("Favor informa a tag");

        if (tagSearch != null && StringUtils.hasText(tagSearch)) {
            logger.info(String.format("Looking for %s", tagSearch));

            Map<String, Object> tagsObject = new HashMap<String, Object>();
            List<Map> listOfTwitters = new ArrayList<>();

            Client client = twitterHBC.build(tagSearch);
            client.connect();
            while (!client.isDone()) {
                if (listOfTwitters.size() >= tagSize) break;
                listOfTwitters.add(jsonUtils.fromJsonToMap(twitterHBC.getTwitter()));
            }
            client.stop();

            logger.info("Finalizado Twitter");
            logger.info("Inserindo Cassandra");
            logger.info(String.valueOf(listOfTwitters.size()));
            twitterProdutoService.inserirTwitterPosts(listOfTwitters, tagSearch);
            logger.info("Finalizando");
             retorno = "Carregado";
        }
        return new ResponseEntity(retorno, HttpStatus.OK);
    }

    @GetMapping("carregar")
    public ResponseEntity carregarCassandra() {
        twitterCassandraService.carregarCassandra();
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping(value = "user/tag", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<TwitterUsersVO>> pegarUsuariosPorTags(@RequestParam(name = "q", required = false) String tagSearch) {
        Iterable<TwitterUsersByFollowers> twitterUsers = twitterProdutoService.pegarUserTwitter(tagSearch);
        List<TwitterUsersVO> listaUserVO = new ArrayList<>();
        for (TwitterUsersByFollowers user : twitterUsers) {
            listaUserVO.add(new TwitterUsersVO(user.getName(), user.getFollowersCount()));
        }
        return new ResponseEntity(listaUserVO, HttpStatus.OK);
    }


    @GetMapping(value = "lang", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<TwitterPostsByLangVO>> pegarPostsPorIdioma(@RequestParam(name = "q", required = false, defaultValue = "pt") String lang) {
        return new ResponseEntity(twitterProdutoService.pegarPostByLang(lang), HttpStatus.OK);
    }

    @GetMapping(value = "data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<TwitterPostsByDateVO>> pegarPostsPorData() {
        return new ResponseEntity(twitterProdutoService.pegarPostByData(), HttpStatus.OK);
    }


}
