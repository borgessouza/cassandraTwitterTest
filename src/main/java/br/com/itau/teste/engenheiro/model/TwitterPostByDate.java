package br.com.itau.teste.engenheiro.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Table("twitter_posts_by_date")
public class TwitterPostByDate implements Serializable {

    @PrimaryKey
    private UUID id;
    private String tagName;
    private Date created;

    public TwitterPostByDate() {
        this.id = UUID.randomUUID();
    }

    public TwitterPostByDate(String tagName, Date created) {
        this.id = UUID.randomUUID();
        this.tagName = tagName;
        this.created = created;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
