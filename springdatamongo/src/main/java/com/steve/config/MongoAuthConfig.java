package com.steve.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import static java.util.Collections.singletonList;


//MongoDBserver3在连接到数据库时改变了身份验证模型。
// 因此，用于身份验证的一些配置选项不再有效。

//您应该使用特定于mongoclient的选项通过MongoCredential设置凭据，以提供身份验证数据
@Configuration
public class MongoAuthConfig extends AbstractMongoConfiguration {

    @Override
    public String getDatabaseName() {
        return "database";
    }
    @Override
    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(singletonList(
                new ServerAddress("127.0.0.1", 27017)),
                singletonList(MongoCredential.createCredential("name",
                        "db", "pwd".toCharArray())));
    }
//    在基于xml的配置中使用的用户名和密码凭据如果包含保留字符（：@，%），
//    则必须使用url编码：（0%40  %3A ）
}
