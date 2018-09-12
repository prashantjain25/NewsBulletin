package com.newsbulletin.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.newsbulletin.entity.Headline;
import com.newsbulletin.model.HeadlineDTO;
import com.newsbulletin.service.NewsDeliveryImpl;

@Controller
public class HeadlinesHandler {
    @Autowired
    private NewsDeliveryImpl newsDelivery;
    
    /**
     * Find by Article Publisher.
     *
     * @param searchTerm the search term
     * @param pageRequest the page request
     * @return the response entity
     */
    @RequestMapping(value = "/newsbulletin/search", method = RequestMethod.GET)
    public ResponseEntity<Object> findBySearchTerm(@RequestParam("searchTerm") String searchTerm, 
                                          Pageable pageRequest) {
        return new ResponseEntity<Object>( newsDelivery.findBySearchTerm(searchTerm, pageRequest), HttpStatus.OK);
    }
    
    /**
     * Fetch articles and sort.
     *
     * @param sortBy the sort by
     * @param sortDirection the sort direction
     * @return the response entity
     */
    @RequestMapping(value = "/newsbulletin", method = RequestMethod.GET)
    public ResponseEntity<Object> fetchArticles(@RequestParam String sortBy, @RequestParam String sortDirection) {
        return new ResponseEntity<Object>( newsDelivery.findAll(sortBy,sortDirection), HttpStatus.OK);
    }
}
