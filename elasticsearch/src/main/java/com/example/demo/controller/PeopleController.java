package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * people controller
 */
@RestController
public class PeopleController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
