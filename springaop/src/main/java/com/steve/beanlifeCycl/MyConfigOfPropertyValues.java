package com.steve.beanlifeCycl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description: 实体类属性赋值相关操作
 * @Author: HiWin10
 * @Date: 2020/2/1321:22
 **/
//@PropertySource取得外部配置文件中的K/V,并保存到spring运行的环境变量中
//      参数为String[]，可以写多个配置文件
@PropertySource("classpath:/custom.properties")
@Configuration
public class MyConfigOfPropertyValues {

    @Bean("computer")
    public Computer computer(){
        return new Computer();
    }
}
