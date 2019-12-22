package com.example.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * 人
 */
public class Person implements BeanFactoryAware
        , BeanNameAware
        , InitializingBean
        , DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(Person.class);

    private String name;

    private Integer age;

    private BeanFactory beanFactory;

    private String beanName;

    public Person() {
        logger.info("【Person无参构造函数】");
    }

    public Person(String name, Integer age) {
        logger.info("【Person有参构造函数】");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.info("【Person设置属性】setName");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        logger.info("【Person设置属性】setAge");
        this.age = age;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("【Person#BeanFactoryAware接口】setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        logger.info("【Person#BeanNameAware接口】setBeanName");
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        logger.info("【Person#DisposableBean接口】destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("【Person#InitializingBean接口】afterPropertiesSet");
    }

    public void myInitMethod() {
        logger.info("【Person#初始化init-method】myInitMethod");
    }

    public void myDestroyMethod() {
        logger.info("【Person#销毁destroy-method】myDestroyMethod");
    }
}
