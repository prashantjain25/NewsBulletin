package com.newsbulletin.model;

import javax.validation.constraints.NotEmpty;

public class HeadlineDTO {
    @NotEmpty
    private String publisher;
    @NotEmpty
    private String articleFeed;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getArticleFeed() {
        return articleFeed;
    }

    public void setArticleFeed(String articleFeed) {
        this.articleFeed = articleFeed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    private Long id;

    private String headlineUrl;

    private String type;
    
    private long identifier;

}
