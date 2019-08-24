package com.example.demo.dao;

import com.example.demo.entity.People;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * es dao
 */
public interface PeopleDao extends ElasticsearchRepository<People, Long> {
}
