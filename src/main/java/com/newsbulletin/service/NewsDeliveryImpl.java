package com.newsbulletin.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsbulletin.entity.Headline;
import com.newsbulletin.entity.Newspaper;
import com.newsbulletin.model.HeadlineDTO;
import com.newsbulletin.model.HeadlineMapper;
import com.newsbulletin.model.NewsRowBinder;
import com.newsbulletin.model.PlatformException;
import com.newsbulletin.repository.HeadlinesRepository;
import com.newsbulletin.repository.NewspaperRepository;
import com.newsbulletin.util.BulletinCSVReader;

@Service
@EnableJpaRepositories("com.newsbulletin.repository")
public class NewsDeliveryImpl implements HeadlinesSearchService{
    @Autowired
    private static BulletinCSVReader impl;
    
    private static HeadlinesRepository repository;
    
    private static NewspaperRepository newsrepository;
    
    @Autowired
    public NewsDeliveryImpl(HeadlinesRepository repository, NewspaperRepository newspaperRepository) {
        this.repository = repository;
        this.newsrepository=newspaperRepository;
    } 
    
    private static final Logger log = LoggerFactory.getLogger(NewsDeliveryImpl.class);

    @PostConstruct
    public void init() throws PlatformException, IOException{
        List ls= impl.reader();
        populateData(ls);
    }
    
    public static void populateData(List<NewsRowBinder> listRows) {
        for(NewsRowBinder rows:listRows) {
            newsrepository.save(rows.getNewspaper());
            repository.save(rows.getHeadlines());
        }
    }
    private PageRequest gotoPage(int page, String sortBy, String sortDirection)
    {
        return PageRequest.of(page,1,sortDirection.equalsIgnoreCase("asc")?Sort.Direction.ASC:Sort.Direction.DESC,sortBy);
        
    }

    public Page<Headline> findAll(String sortBy, String sortDirection)
    { //List he=repository.findAll();
        Page<Headline> listPage = repository.findAll(gotoPage(0, sortBy, sortDirection));
        
        /*List<Headline> ls=new ArrayList<>();
        for(Headline head : listPage)
        ls.add(head);
        return ls;*/
        return listPage;
    }
    @Transactional(readOnly = true)
    public Page<HeadlineDTO> findBySearchTerm(String searchTerm, Pageable pageRequest) {
        //Obtain search results by invoking the preferred repository method.
       Specification sp= HeadlineSpecification.publisherIgnoreCase(searchTerm);
        Page<Headline> searchResultPage = repository.findAll(sp, pageRequest);
        log.info("Found {} Headline entries. Returned page {} contains {} Headline entries",
                searchResultPage.getTotalElements(),
                searchResultPage.getNumber(),
                searchResultPage.getNumberOfElements()
        );
        return HeadlineMapper.mapEntityPageIntoDTOPage(pageRequest, searchResultPage);
    }
    
}
