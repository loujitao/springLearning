package com.steve.autoware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Description: 测试自动注入相关内容
 * @Author: SteveTao
 * @Date: 2020/2/1321:49
 **/
@Configuration()
@ComponentScan(basePackages = "com.steve.autoware")
public class AutowareConfig {

    @Primary
    @Bean("aDao2")
    public ADao aDao(){
        ADao aDao = new ADao();
        aDao.setId("1");
        return aDao;
    }
}
