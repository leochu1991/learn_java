# Spring

## 1.1 bean的生命周期

#### 参考文章
+ [Spring Bean的生命周期（非常详细）](https://www.cnblogs.com/zrtqsk/p/3735273.html)

~~~bash
【MyBeanFactoryPostProcessor构造函数】
【MyBeanFactoryPostProcessor#BeanFactoryPostProcessor接口】postProcessBeanFactory
【MyBeanPostProcessor构造函数】
【MyInstantiationAwareBeanPostProcessor构造函数】
【MyInstantiationAwareBeanPostProcessor#InstantiationAwareBeanPostProcessorAdapter抽象类】postProcessBeforeInstantiation
【Person无参构造函数】
【MyInstantiationAwareBeanPostProcessor#InstantiationAwareBeanPostProcessorAdapter抽象类】postProcessAfterInstantiation
【MyInstantiationAwareBeanPostProcessor#InstantiationAwareBeanPostProcessorAdapter抽象类】postProcessPropertyValues
【Person设置属性】setName
【Person设置属性】setAge
【Person#BeanNameAware接口】setBeanName
【Person#BeanFactoryAware接口】setBeanFactory
【MyBeanPostProcessor#BeanPostProcessor接口】postProcessBeforeInitialization
【Person#InitializingBean接口】afterPropertiesSet
【Person#初始化init-method】myInitMethod
【MyBeanPostProcessor#BeanPostProcessor接口】postProcessAfterInitialization
【Person使用】:{"name":"小明","age":22}
【Person#DisposableBean接口】destroy
【Person#销毁destroy-method】myDestroyMethod
~~~

## 1.2 bean的循环依赖

#### 参考文章
+ []()

## 1.3 AutoWired注解实现原理


## 1.4 Spring事务实现原理


## 1.5 Spring Aop


## 1.5 Spring controller单例

