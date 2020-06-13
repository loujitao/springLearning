package com.steve.mainTest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.steve.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Slf4j
public class mongoTest01 {

    public static void main(String[] args) {
        test01();
    }

    private static void test01(){
        //默认会连接到    locahost:27017  的 mytest数据库中
//        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "mytest");

        //您可以在标准Java代码中使用它们，而不是使用IoC容器来创建MongoTemplate的实例
        MongoOperations mongoOps = new MongoTemplate(
                                         new SimpleMongoDbFactory(
                                             new MongoClient(), "mytest"));

        //插入数据到库中， 未指定collection时会以对象名创建数据集
        mongoOps.insert(new Person("Joe", 34));
        log.info(String.valueOf(mongoOps.findOne(new Query(Criteria.where("name").is("Joe")), Person.class)));
        //删除刚刚创建的数据集person
        mongoOps.dropCollection("person");
    }
}
