package com.newsbulletin.service;

import org.springframework.data.jpa.domain.Specification;

import com.newsbulletin.entity.Headline;

public class HeadlineSpecification {
    private HeadlineSpecification() {}
    
    static Specification<Headline> publisherIgnoreCase(String searchTerm) {
        return (root, query, cb) -> {
            String containsLikePattern = getContainsPatternLike(searchTerm);
            return cb.like(cb.lower(root.<String>get("newspaper").<String>get("publisher")), containsLikePattern);
        };
    }

    private static String getContainsPatternLike(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        }
        else {
            return "%" + searchTerm.toLowerCase() + "%";
        }
    }
}
