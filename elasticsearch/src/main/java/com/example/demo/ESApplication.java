package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ESApplication {

    public static void main(String[] args) {
        SpringApplication.run(ESApplication.class, args);
        System.out.printf(">>>>ESApplication starts, args:%s<<<<%n", JSON.toJSONString(args));
    }

}
