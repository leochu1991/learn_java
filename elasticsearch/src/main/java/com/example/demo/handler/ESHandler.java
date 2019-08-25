package com.example.demo.handler;

import com.example.demo.client.ESClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * es handler
 */
@Component
public class ESHandler {

    @Autowired
    private ESClient esClient;

}
