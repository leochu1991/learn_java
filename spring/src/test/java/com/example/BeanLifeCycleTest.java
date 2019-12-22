package com.example;

import com.example.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean的生命周期
 */
public class BeanLifeCycleTest {
    private static Logger logger = LoggerFactory.getLogger(BeanLifeCycleTest.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext atx =
                new ClassPathXmlApplicationContext("classpath:beans.xml");

        Person person = atx.getBean("person", Person.class);
        ObjectMapper objectMapper = new ObjectMapper();
        logger.info("【Person使用】:" + objectMapper.writeValueAsString(person));

        atx.registerShutdownHook();
    }
}
