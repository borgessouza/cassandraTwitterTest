package br.com.itau.teste.engenheiro.services;

import br.com.itau.teste.engenheiro.VO.TwitterPostsByDateVO;
import br.com.itau.teste.engenheiro.VO.TwitterPostsByLangVO;
import br.com.itau.teste.engenheiro.model.TwitterUsersByFollowers;

import java.util.List;
import java.util.Map;

public interface TwitterProdutoService {

    Iterable<TwitterUsersByFollowers> pegarUserTwitter(String tagSearch);

    void inserirTwitterPosts(List<Map> listOfTwitters, String tagSearch);

    List<TwitterPostsByLangVO> pegarPostByLang(String lang);

    List<TwitterPostsByDateVO> pegarPostByData();
}
