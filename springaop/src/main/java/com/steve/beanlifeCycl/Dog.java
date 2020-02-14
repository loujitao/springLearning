package com.steve.beanlifeCycl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1316:11
 **/
public class Dog{
    public Dog() {
        System.out.println("Dog 构造方法。。。");
    }

    @PostConstruct
    public void init(){
        System.out.println("Dog init method ....");
    }

    @PreDestroy
    public void destory(){
        System.out.println( "Dog destory method ...");
    }

}
