package com.steve.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description: spring上下文工具类
 * @Author: SteveTao
 * @Date: 2020/9/2314:10
 **/
@Component
public class SpringContextUtil implements ApplicationContextAware{

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext=applicationContext;
    }

    //获取spring上下文
    public static ApplicationContext getApplicationContext(){return  applicationContext;}

    //根据beanName获取bean
    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

    //根据类加载
    public static Object getBean(Class<?> clz){
        return applicationContext.getBean(clz);
    }

}
