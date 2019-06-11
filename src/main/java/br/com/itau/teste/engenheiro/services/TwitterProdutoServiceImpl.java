package br.com.itau.teste.engenheiro.services;

import br.com.itau.teste.engenheiro.facade.TwitterCassandraFacade;
import br.com.itau.teste.engenheiro.model.TwitterPosts;
import br.com.itau.teste.engenheiro.model.TwitterPostsByLang;
import br.com.itau.teste.engenheiro.model.TwitterUsersByFollowers;
import br.com.itau.teste.engenheiro.repositories.TwitterPostRepository;
import br.com.itau.teste.engenheiro.repositories.TwitterPostsByLangRepository;
import br.com.itau.teste.engenheiro.repositories.TwitterUsersRepository;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
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

    @Override
    public Iterable<TwitterUsersByFollowers> pegarUserTwitter(String tagSearch) {
        if (tagSearch == null || tagSearch.isEmpty())
            return twitterUsersRepository.findTop5By();
        else
            return twitterUsersRepository.findTop5BytagName(tagSearch);

    }

    public void inserirTwitterPosts(List<Map> listOfTwitters, String tagName) {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        List<TwitterPosts> listaPosts = new ArrayList<>();
        for (Map twitter : listOfTwitters) {
            LinkedTreeMap<String, Object> user = (LinkedTreeMap) twitter.get("user");

            listaPosts.add(new TwitterPosts(user.get("screen_name").toString(),
                    tagName,
                    Double.valueOf(user.get("followers_count").toString()),
                    Double.valueOf(user.get("friends_count").toString()),
                    Double.valueOf(user.get("listed_count").toString()),
                    Double.valueOf(user.get("favourites_count").toString()),
                    twitter.get("lang").toString(),
                    Calendar.getInstance().getTime(),
                    twitter.get("text").toString()
            ));
        }

        twitterPostRepository.saveAll(listaPosts);
    }

    public Map<String, List<TwitterPostsByLang>> pegarPostByLang(String lang) {
        List<TwitterPostsByLang> lista = twitterPostsByLangRepository.findAll();
        Map<String, List<TwitterPostsByLang>> resultado = lista.stream().collect(Collectors.groupingBy(TwitterPostsByLang::getLang));
        return resultado;
    }
}
