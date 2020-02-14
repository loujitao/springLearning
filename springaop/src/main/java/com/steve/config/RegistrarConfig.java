package com.steve.config;

import com.steve.entity.Person;
import com.steve.entity.Student;
import com.steve.util.MyImportBeanDefinitionRegistrar;
import com.steve.util.MyImportSelector;
import com.steve.util.ParentFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1315:15
 **/
@Configuration
@Import({Student.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class RegistrarConfig {
    /**
     *  给容器中注册组件Bean
     *  1) 包扫描； 组件标注注解（@Controller,@Service,@Dao,@Repository,@Compent）
     *  2) @Bean：导入第三方包里的组件。配置类中注入
     * 3）@Import 快速导入一个组件，配置类上
     *      1、@Import( 要导入的组件 )：容器中就会自动注入该组件，Bean的Id默认为全类名
     *                      Student.class
     *      2、ImportSelector子类： 返回需要导入组件的全类名String数组
     *                  MyImportSelector.class
     *      3、ImportBeanDefinitionRegistrar子类: 利用方法中BeanDefinitionRegistrar，手动注入组件Bean
     *               MyImportBeanDefinitionRegistrar.class
     * 4) 使用Spring提供的FactoryBean(工厂Bean)：
     *      注入容器的是工厂bean的名字，类型却是实例bean的
     *      1、默认获取到的是工厂bean调用getObject拿到的对象
     *      2、要想获取工厂bean本身，需要再ID前面加一个&前缀    getBean("&xxxFactoryBean")
     **/
    @Bean
    public Person person(){
        return new Person("zhangsan",23);
    }

    @Bean
    public ParentFactoryBean parentFactoryBean(){
        return new ParentFactoryBean();
    }
}
