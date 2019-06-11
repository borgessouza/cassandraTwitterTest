package br.com.itau.teste.engenheiro.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Table("twitter_posts")
public class TwitterPosts implements Serializable {

    @PrimaryKey
    private UUID id;
    private String userName;
    private String tagName;
    private String text;
    private Double followersCount;
    private Double friendsCount;
    private Double listedCount;
    private Double favouritesCount;
    private String lang;
    private Date created;

    public TwitterPosts(String userName, String tagName, Double followersCount, Double friendsCount, Double listedCount, Double favouritesCount, String lang, Date created, String text) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.tagName = tagName;
        this.followersCount = followersCount;
        this.friendsCount = friendsCount;
        this.listedCount = listedCount;
        this.favouritesCount = favouritesCount;
        this.lang = lang;
        this.created = created;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Double getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Double followersCount) {
        this.followersCount = followersCount;
    }

    public Double getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Double friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Double getListedCount() {
        return listedCount;
    }

    public void setListedCount(Double listedCount) {
        this.listedCount = listedCount;
    }

    public Double getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Double favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
