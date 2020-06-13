package com.steve.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfig {

    //方式一、注册com.mongodb.MongoClient到spring的IOC容器中
    public @Bean  MongoClient mongoClient() {
        return new MongoClient("localhost");
    }

    //方式二、注册com.mongodb.MongoClient对象，使用Spring的MongoClientFactoryBean
    // 并启用Spring的异常转换支持
    public @Bean   MongoClientFactoryBean mongoClientFactoryBean() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }

    //向容器注册一个MongoDbFactory实例
    public @Bean  MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(new MongoClient(), "database");
    }

}
