package com.steve.mainTest;

import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

@Slf4j
public class mongoTest02 {

    public static void main(String[] args) {
        test01();
    }
//    Update update=new Update().rename("old_key", "new_key");

    //修改键和值
    private static void test01(){
        //默认会连接到    locahost:27017  的 mytest数据库中
        MongoTemplate template = new MongoTemplate(MongoClients.create(), "mytest");
        Update update =new Update();
        update.set("content.renwu.fieldName","任务");
        Query query = Query.query( Criteria.where("dmKey").is("T001") );
        template.updateFirst(query, update, Document.class,"tb_dm");

        Update update2 =new Update();
        update2.rename("content.renwu","content.taskName");
        template.updateFirst(query, update2, Document.class,"tb_dm");
    }

    //修改键
    private static void test04(){
        //默认会连接到    locahost:27017  的 mytest数据库中
        MongoTemplate template = new MongoTemplate(MongoClients.create(), "mytest");
        Update update =new Update();
        update.rename("content.taskName","content.renwu");
        Query query = Query.query( Criteria.where("dmKey").is("T001") );
        template.updateFirst(query, update, Document.class,"tb_dm");
    }


    //修改dmkey=T001数据中， 数组dmList中key=100000014的fieldName，definition字段
    private static void test03(){
        //默认会连接到    locahost:27017  的 mytest数据库中
        MongoTemplate template = new MongoTemplate(MongoClients.create(), "mytest");
        Update update =new Update();
        update.set("dmList.$.fieldName", "renwu");
        update.set("dmList.$.definition", "renwu");
        Query query = Query.query(new Criteria().andOperator(
                Criteria.where("dmKey").is("T001"),
                Criteria.where("dmList").elemMatch(
                        Criteria.where("key").is("100000014")
                )
        ));
        template.updateFirst(query, update, Document.class,"tb_dm");
    }

    //查询
    private static void test02(){
        //默认会连接到    locahost:27017  的 mytest数据库中
        MongoTemplate template = new MongoTemplate(MongoClients.create(), "mytest");
        Query query = new Query().addCriteria(Criteria.where("dmKey").is("T001"));
        List<Document> documents = template.find(query, Document.class,"tb_dm");
        System.out.println(documents.size());
    }



}
