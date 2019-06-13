package br.com.itau.teste.engenheiro.services;

import br.com.itau.teste.engenheiro.VO.TwitterPostsByDateVO;
import br.com.itau.teste.engenheiro.VO.TwitterPostsByLangVO;
import br.com.itau.teste.engenheiro.facade.TwitterCassandraFacade;
import br.com.itau.teste.engenheiro.model.TwitterPostByData;
import br.com.itau.teste.engenheiro.model.TwitterPosts;
import br.com.itau.teste.engenheiro.model.TwitterPostsByLang;
import br.com.itau.teste.engenheiro.model.TwitterUsersByFollowers;
import br.com.itau.teste.engenheiro.repositories.TwitterPostRepository;
import br.com.itau.teste.engenheiro.repositories.TwitterPostsByDataRepository;
import br.com.itau.teste.engenheiro.repositories.TwitterPostsByLangRepository;
import br.com.itau.teste.engenheiro.repositories.TwitterUsersRepository;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TwitterProdutoServiceImpl implements TwitterProdutoService {

    @Autowired
    private TwitterCassandraFacade twitterCassandraFacade;
    @Autowired
    private TwitterUsersRepository twitterUsersRepository;
    @Autowired
    private TwitterPostsByLangRepository twitterPostsByLangRepository;
    @Autowired
    private TwitterPostRepository twitterPostRepository;
    @Autowired
    private TwitterPostsByDataRepository twitterPostsByDataRepository;


    @Override
    public Iterable<TwitterUsersByFollowers> pegarUserTwitter(String tagSearch) {
        if (tagSearch == null || tagSearch.isEmpty())
            return twitterUsersRepository.findTop5By();
        else
            return twitterUsersRepository.findTop5BytagName(tagSearch);

    }

    public void inserirTwitterPosts(List<Map> listOfTwitters, String tagName) {
        List<TwitterPosts> listaPosts = new ArrayList<>();
        listOfTwitters.forEach( twitter -> {
            LinkedTreeMap<String, Object> user = (LinkedTreeMap) twitter.get("user");
            listaPosts.add(new TwitterPosts(user.get("screen_name").toString(),
                    tagName,
                    Double.valueOf(user.get("followers_count").toString()),
                    Double.valueOf(user.get("friends_count").toString()),
                    Double.valueOf(user.get("listed_count").toString()),
                    Double.valueOf(user.get("favourites_count").toString()),
                    twitter.get("lang").toString(),
                    new Date(Long.valueOf(twitter.get("timestamp_ms").toString())),
                    twitter.get("text").toString()
            ));
        });
        twitterPostRepository.saveAll(listaPosts);
    }

    public List<TwitterPostsByLangVO> pegarPostByLang(String lang) {
        List<Map<String,String>> lista = twitterPostsByLangRepository.findByPTLangGroupBy(lang);
        List<TwitterPostsByLangVO> retorno =  new ArrayList<>();
        lista.forEach(item -> { retorno.add(new TwitterPostsByLangVO(item.get("count"),
                item.get("tagname"))) ;
        });
        return retorno;
    }

    @Override
    public List<TwitterPostsByDateVO> pegarPostByData() {
        List<Map<String,String>> lista = twitterPostsByDataRepository.findByData();
        List<TwitterPostsByDateVO> retorno =  new ArrayList<>();
        lista.forEach(item -> { retorno.add(new TwitterPostsByDateVO(item.get("total"),
                item.get("hora"))) ;
        });
        return retorno;
    }
}
