package br.com.itau.teste.engenheiro.model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table("twitter_users_by_followers")
public class TwitterUsersByFollowers implements Serializable {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private String name;
    private String tagName;
    private Double followersCount;
    private Double friendsCount;
    private Double listedCount;
    private Double favouritesCount;

    public TwitterUsersByFollowers() {
    }

    public TwitterUsersByFollowers(String name, String tagName, Double followersCount, Double friendsCount, Double listedCount, Double favouritesCount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.tagName = tagName;
        this.followersCount = followersCount;
        this.friendsCount = friendsCount;
        this.listedCount = listedCount;
        this.favouritesCount = favouritesCount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
