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

    public Person(String name, Integer age) {
        logger.info("【构造函数】");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.info("【设置属性】setName");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        logger.info("【设置属性】setAge");
        this.age = age;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("【BeanFactoryAware接口】setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        logger.info("【BeanNameAware接口】setBeanName");
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        logger.info("【DisposableBean接口】destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("【InitializingBean接口】afterPropertiesSet");
    }

    public void myInitMethod() {
        logger.info("【初始化init-method】myInitMethod");
    }

    public void myDestroyMethod() {
        logger.info("【销毁destroy-method】myDestroyMethod");
    }
}
