package com.steve.test;

import com.steve.config.PersonConfigration;
import com.steve.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: TODO
 * @Author: SteveTao
 * @Date: 2019/11/816:51
 **/
public class MainTest {

    public static void main(String[] args) {
        //通过xml的方式向容器中注入bean   需要Bean.xml 和实体类Person
//        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("Bean.xml");
//        Person person = (Person) xmlApplicationContext.getBean("person");
//        System.out.println(person);

        //通过注解向容器中注入Bean 没有包扫描时需要指定配置类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfigration.class);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);


    }
}
