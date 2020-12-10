package com.scraping.dao;

import org.springframework.data.repository.CrudRepository;

import com.scraping.model.AmazonData;

public interface AmazonRepository extends CrudRepository<AmazonData, Integer> {

}
