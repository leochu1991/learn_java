package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;


/**
 * es model
 */
@Document(indexName = "objects", type = "people")
@Data
public class People {
    @Id
    private Long id;

    private String name;

    private String hometown;

    private Integer age;

    private LocalDate birthday;
}
