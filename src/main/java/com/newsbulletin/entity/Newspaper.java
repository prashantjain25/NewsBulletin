package com.newsbulletin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "newspaper")
public class Newspaper {
    @Id
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequenceName",
                            value = "sequence"),
                    @org.hibernate.annotations.Parameter(
                            name = "allocationSize", value = "1"), })
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @Column(name="publisherid")
    private long id;
    
    @Column(name="publisher")
    private String publisher;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDomainUrl() {
        return domainUrl;
    }

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    public List<Headline> getHeadline() {
        return headline;
    }

    public void setHeadline(List<Headline> headline) {
        this.headline = headline;
    }

    @Column(name = "domain")
    private String domainUrl;

    @OneToMany(mappedBy = "newspaper", cascade = CascadeType.ALL,fetch=FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private List<Headline> headline;

    

    
    

}
