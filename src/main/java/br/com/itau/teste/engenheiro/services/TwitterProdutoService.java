package br.com.itau.teste.engenheiro.services;

import br.com.itau.teste.engenheiro.model.TwitterPostsByLang;
import br.com.itau.teste.engenheiro.model.TwitterUsersByFollowers;

import java.util.List;
import java.util.Map;

public interface TwitterProdutoService {

    Iterable<TwitterUsersByFollowers> pegarUserTwitter(String tagSearch);

    void inserirTwitterPosts(List<Map> listOfTwitters, String tagSearch);

    Map<String, List<TwitterPostsByLang>> pegarPostByLang(String lang);
}
