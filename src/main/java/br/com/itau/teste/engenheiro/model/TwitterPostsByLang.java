package br.com.itau.teste.engenheiro.model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table("twitter_posts_by_lang")
public class TwitterPostsByLang  implements Serializable {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    @CassandraType(type = DataType.Name.VARCHAR)
    private String lang;
    @CassandraType(type = DataType.Name.VARCHAR)
    private String tagname;
    private String text;

    public TwitterPostsByLang() {
        this.id = UUID.randomUUID();
    }

    public TwitterPostsByLang(String lang, String tagname, String text) {
        this.id = UUID.randomUUID();
        this.lang = lang;
        this.tagname = tagname;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
