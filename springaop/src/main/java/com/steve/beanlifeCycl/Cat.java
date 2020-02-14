package com.steve.beanlifeCycl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1316:06
 **/
public class Cat implements InitializingBean, DisposableBean{
    public Cat() {
        System.out.println("Cat 构造方法。。。");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat .... destroy()...销毁方法 ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat .... afterPropertiesSet()...初始化方法 ");
    }
}
