package com.example.demo.entity;

import com.example.demo.annotation.ESDocument;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;


/**
 * es model
 */
@Data
@ESDocument(indexAlias = "objects", indexType = "people")
public class People {
    @Id
    private Long id;

    private String name;

    private String hometown;

    private Integer age;

    private LocalDate birthday;
}
