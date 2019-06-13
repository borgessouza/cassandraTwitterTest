package br.com.itau.teste.engenheiro.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Table("twitter_posts_by_date")
public class TwitterPostByData implements Serializable {

    @PrimaryKey
    private UUID id;
    private String tagName;
    private String text;
    private Date created;
    private Integer dia;
    private Integer hora;

    public TwitterPostByData() {
        this.id = UUID.randomUUID();
    }

    public TwitterPostByData(String tagName, Date created) {
        this.id = UUID.randomUUID();
        this.tagName = tagName;
        this.created = created;
    }

    public TwitterPostByData(String tagName, Date created, Integer dia, Integer hora, String text) {
        this.id = UUID.randomUUID();
        this.tagName = tagName;
        this.created = created;
        this.hora = hora;
        this.dia = dia;
        this.text = text;
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

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
