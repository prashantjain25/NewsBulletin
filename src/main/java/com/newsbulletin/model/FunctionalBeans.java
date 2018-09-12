package com.newsbulletin.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.newsbulletin.entity.Headline;
import com.newsbulletin.entity.Newspaper;

@Configuration
public class FunctionalBeans {

    @Bean
    public Headline getHeadline() {
        return new Headline();
    }
    @Bean
    public Newspaper getNewspaper() {
        return new Newspaper();
    }
}
