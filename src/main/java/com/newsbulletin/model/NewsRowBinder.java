package com.newsbulletin.model;

import com.newsbulletin.entity.Headline;
import com.newsbulletin.entity.Newspaper;

public class NewsRowBinder {
    public Headline getHeadlines() {
        return headlines;
    }
    public void setHeadlines(Headline headlines) {
        this.headlines = headlines;
    }
    public Newspaper getNewspaper() {
        return newspaper;
    }
    public void setNewspaper(Newspaper newspaper) {
        this.newspaper = newspaper;
    }
    Headline headlines;
    Newspaper newspaper;
}
