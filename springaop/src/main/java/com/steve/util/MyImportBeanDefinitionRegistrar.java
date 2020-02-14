package com.steve.util;

import com.steve.entity.Children;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1315:24
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //指定bean名  手动注入，这里还可以加一些逻辑判断
        BeanDefinition beanDefinition=new RootBeanDefinition(Children.class);
        //判断容器中是否有Teacher这个组件
        boolean bool = registry.containsBeanDefinition("Teacher");
        registry.registerBeanDefinition("Children",beanDefinition);
    }
}
