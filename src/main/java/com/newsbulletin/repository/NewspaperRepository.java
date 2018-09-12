package com.newsbulletin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newsbulletin.entity.Newspaper;
@Repository
public interface NewspaperRepository extends CrudRepository<Newspaper,Long>{
    
}
