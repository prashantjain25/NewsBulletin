package com.newsbulletin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.newsbulletin.model.HeadlineDTO;

public interface HeadlinesSearchService {
    Page<HeadlineDTO> findBySearchTerm(String searchTerm, Pageable pageRequest);
}
