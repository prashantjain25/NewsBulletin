package com.newsbulletin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.newsbulletin.entity.Headline;

@Repository
public interface HeadlinesRepository 
extends JpaRepository<Headline, Long>,PagingAndSortingRepository<Headline, Long>, JpaSpecificationExecutor<Headline>{
    public Headline findById(long id);
    public List<Headline> findAll();
    @Query("select head from Headline head where head.identifier=?1")
    public long findByIdentifier(long uidIdentifier);
}
