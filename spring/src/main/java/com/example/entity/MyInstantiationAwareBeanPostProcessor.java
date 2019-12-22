package com.example.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * 自定义InstantiationAwareBeanPostProcessorAdapter
 * 适配器模式：抽象类实现接口，通过继承，重写抽象类方法
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(MyInstantiationAwareBeanPostProcessor.class);

    public MyInstantiationAwareBeanPostProcessor() {
        logger.info("【MyInstantiationAwareBeanPostProcessor构造函数】");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        logger.info("【MyInstantiationAwareBeanPostProcessor#InstantiationAwareBeanPostProcessorAdapter抽象类】postProcessBeforeInstantiation");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        logger.info("【MyInstantiationAwareBeanPostProcessor#InstantiationAwareBeanPostProcessorAdapter抽象类】postProcessAfterInstantiation");
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        logger.info("【MyInstantiationAwareBeanPostProcessor#InstantiationAwareBeanPostProcessorAdapter抽象类】postProcessPropertyValues");
        return pvs;
    }
}
