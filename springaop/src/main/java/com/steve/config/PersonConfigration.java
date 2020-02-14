package com.steve.config;

import com.steve.entity.Person;
import com.steve.util.LinuxCondition;
import com.steve.util.WindowCondition;
import org.springframework.context.annotation.*;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1215:04
 **/
@Configuration
public class PersonConfigration {

    //@Scope 实体类的作用域:
    //      singleton: 单实例，容器创建时同时就创建
    //              @Lazy  只用于单实例，第一获取的时候再创建，后面获取不再创建
    //      prototype:  多实例，容器创建时不创建，每次获取时创建一个新的
    //      request:  同一次请求创建一个实例
    //      session:   同一次会话创建一个实例
    @Scope("prototype")
//    @Lazy
    @Bean
    public Person person(){
        System.out.println("向容器中添加Bean: person");
        return new Person("lixing",24);
    }

    //如果是Windows环境注入实体Bean-bill
    //如果是Linux环境注入实体Bean-linus
    //也可用着类上面  满足条件该类下的所有实体才会注入IOC中
    @Conditional({WindowCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("bill",65);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus",48);
    }

}
