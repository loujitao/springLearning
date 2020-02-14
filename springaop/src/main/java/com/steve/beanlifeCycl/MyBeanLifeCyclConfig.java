package com.steve.beanlifeCycl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1315:48
 **/
@Configuration
public class MyBeanLifeCyclConfig {

    /**
     * 方法一： 配置文件或者注解上，指明init() 和 destroy()
     * 初始化;
     *          对象初始化并赋值好以后，调用初始化方法
     * 销毁：
     *      单实例，容器关闭时调用销毁方法
     *      多实例，不会被容器管理，需要手动调用销毁方法
     **/
    @Scope("singleton")
    @Bean(value = "sthing",initMethod = "init",destroyMethod = "destory")
    public Something something(){
        return new Something();
    }

    /**
     * 方法二： 通过实现InitializingBean, DisposableBean接口，定义初始化和销毁方法
     * @return
     */
    @Bean
    public Cat cat(){
        return new Cat();
    }
    /**
     * 方法三： JSR250，通过 @PostConstruct,  @PreDestroy注解，定义初始化和销毁方法
     * @return
     */
    @Bean
    public Dog dog(){
        return new Dog();
    }

    /**
     * 方法四：BeanPostProcessor 接口：bean的后置处理器
     *      postProcessBeforeInitialization:  任何初始化方法之前调用
     *      postProcessAfterInitialization:   所有初始化方法之后调用
     */
    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

}
