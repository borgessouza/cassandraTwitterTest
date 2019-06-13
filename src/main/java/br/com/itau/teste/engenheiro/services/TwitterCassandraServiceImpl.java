package br.com.itau.teste.engenheiro.services;

import br.com.itau.teste.engenheiro.facade.TwitterCassandraFacade;
import br.com.itau.teste.engenheiro.model.TwitterPosts;
import br.com.itau.teste.engenheiro.repositories.TwitterPostRepository;
import br.com.itau.teste.engenheiro.repositories.TwitterPostsByDataRepository;
import br.com.itau.teste.engenheiro.repositories.TwitterPostsByLangRepository;
import br.com.itau.teste.engenheiro.repositories.TwitterUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwitterCassandraServiceImpl implements TwitterCassandraService {

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
    public void carregarCassandra() {
        List<TwitterPosts> listaPosts = twitterPostRepository.findAll();
        twitterUsersRepository.saveAll(
                twitterCassandraFacade.converterTwitterUserByFollors(listaPosts));
        twitterPostsByLangRepository.saveAll(
                twitterCassandraFacade.convertTwitterPostByLang(listaPosts));
        twitterPostsByDataRepository.saveAll(
                twitterCassandraFacade.convertTwitterPostByDate(listaPosts));
    }

}
