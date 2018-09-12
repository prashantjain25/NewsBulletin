package com.newsbulletin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "headline")
public class Headline {

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequenceName",
                            value = "sequence"),
                    @org.hibernate.annotations.Parameter(
                            name = "allocationSize", value = "1"), })
    @Column(name = "headlineid")
    private long id;

    @Column
    private String headlines;
    @Column
    private String headlineUrl;
    @Column
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeadlines() {
        return headlines;
    }

    public void setHeadlines(String headlines) {
        this.headlines = headlines;
    }

    public String getHeadlineUrl() {
        return headlineUrl;
    }

    public void setHeadlineUrl(String headlineUrl) {
        this.headlineUrl = headlineUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public Newspaper getNewspaper() {
        return newspaper;
    }

    public void setNewspaper(Newspaper newspaper) {
        this.newspaper = newspaper;
    }

    @Column(unique = true)
    private long identifier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisherid")
    @JsonBackReference
    private Newspaper newspaper;

}
