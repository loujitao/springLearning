package com.steve.util;

import com.steve.entity.Parent;
import com.steve.entity.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1315:33
 **/
public class ParentFactoryBean implements FactoryBean<Parent> {
    @Override
    public Parent getObject() throws Exception {
        System.out.println("通过ParentFactoryBean的getObject方法获取实例。。。");
        return new Parent();
    }

    @Override
    public Class<?> getObjectType() {
        return Parent.class;
    }
    //是否是单利的。 单利只有一个实例；多利每次都调用getObject方法获取不同实例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
