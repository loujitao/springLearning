package com.steve.beanlifeCycl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description: 实体类的后置处理器，
 *      在实体类实例化赋值后加载该类，在初始化方法调用前后调用对应方法
 * @Author: HiWin10
 * @Date: 2020/2/1320:59
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {
    //初始化方法前调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization----"+ beanName+"  :  "+bean);
        return bean;
    }
    //初始化方法后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization      "+ beanName+"  :  "+bean);
        return bean;
    }
}
