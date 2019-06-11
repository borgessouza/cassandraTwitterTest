package br.com.itau.teste.engenheiro.facade;

import br.com.itau.teste.engenheiro.model.TwitterPostByDate;
import br.com.itau.teste.engenheiro.model.TwitterPosts;
import br.com.itau.teste.engenheiro.model.TwitterPostsByLang;
import br.com.itau.teste.engenheiro.model.TwitterUsersByFollowers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TwitterCassandraFacade {

    public List<TwitterUsersByFollowers> converterTwitterUserByFollors(List<TwitterPosts> listOfTwitters) {
        List<TwitterUsersByFollowers> listOfUsers = new ArrayList<>();
        for (TwitterPosts post : listOfTwitters) {
            listOfUsers.add(new TwitterUsersByFollowers(post.getUserName(),
                    post.getTagName(), post.getFollowersCount(), post.getFriendsCount(),
                    post.getListedCount(), post.getFavouritesCount()));
        }

        return listOfUsers;
    }

    public List<TwitterPostsByLang> convertTwitterPostByLang(List<TwitterPosts> listOfTwitters) {
        List<TwitterPostsByLang> listOfPostBylang = new ArrayList<>();
        for ( TwitterPosts post : listOfTwitters) {
            listOfPostBylang.add( new TwitterPostsByLang(post.getLang(), post.getTagName(),
                    post.getText()));
        }
        return listOfPostBylang;
    }

    public  List<TwitterPostByDate> convertTwitterPostByDate(List<TwitterPosts> listOfTwitters) {
        List<TwitterPostByDate> listOfPostByDate = new ArrayList<>();
        for (TwitterPosts post: listOfTwitters) {
            listOfPostByDate.add( new TwitterPostByDate(post.getTagName(),
                    post.getCreated()));
        }
        return listOfPostByDate;
    }
}
