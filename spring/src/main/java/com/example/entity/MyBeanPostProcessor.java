package com.example.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 自定义beanPostProcessor
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);

    public MyBeanPostProcessor() {
        logger.info("【MyBeanPostProcessor构造函数】");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("【MyBeanPostProcessor#BeanPostProcessor接口】postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("【MyBeanPostProcessor#BeanPostProcessor接口】postProcessAfterInitialization");
        return bean;
    }
}
