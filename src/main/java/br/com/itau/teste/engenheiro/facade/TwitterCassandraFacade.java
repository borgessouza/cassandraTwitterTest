package br.com.itau.teste.engenheiro.facade;

import br.com.itau.teste.engenheiro.model.TwitterPostByData;
import br.com.itau.teste.engenheiro.model.TwitterPosts;
import br.com.itau.teste.engenheiro.model.TwitterPostsByLang;
import br.com.itau.teste.engenheiro.model.TwitterUsersByFollowers;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class TwitterCassandraFacade {

    public List<TwitterUsersByFollowers> converterTwitterUserByFollors(List<TwitterPosts> listOfTwitters) {
        List<TwitterUsersByFollowers> listOfUsers = new ArrayList<>();
        listOfTwitters.forEach(post -> {
            listOfUsers.add(new TwitterUsersByFollowers(post.getUserName(),
                    post.getTagName(), post.getFollowersCount(), post.getFriendsCount(),
                    post.getListedCount(), post.getFavouritesCount()));
        });
        return listOfUsers;
    }

    public List<TwitterPostsByLang> convertTwitterPostByLang(List<TwitterPosts> listOfTwitters) {
        List<TwitterPostsByLang> listOfPostBylang = new ArrayList<>();
        listOfTwitters.forEach(post -> {
            listOfPostBylang.add( new TwitterPostsByLang(post.getLang(), post.getTagName(),
                    post.getText()));
        });
       return listOfPostBylang;
    }

    public  List<TwitterPostByData> convertTwitterPostByDate(List<TwitterPosts> listOfTwitters) {
        List<TwitterPostByData> listOfPostByDate = new ArrayList<>();
       listOfTwitters.forEach(post -> {
           LocalDate data = post.getCreated().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           LocalDateTime hora = LocalDateTime.ofInstant(post.getCreated().toInstant(),ZoneId.systemDefault());
           listOfPostByDate.add( new TwitterPostByData(post.getTagName(),
                   post.getCreated(), data.getDayOfMonth(), hora.getHour(), post.getText()));
       });
       return listOfPostByDate;
    }
}
