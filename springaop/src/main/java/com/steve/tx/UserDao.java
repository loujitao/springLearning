package com.steve.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Random;
import java.util.UUID;

/**
 * @Description: TODO
 * @Author: SteveTao
 * @Date: 2020/2/1514:46
 **/
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql="insert into person(name,age) VALUES( ?,?)";
        String name= UUID.randomUUID().toString().substring(0,5);
        int age=new Random(100).nextInt();
         jdbcTemplate.update(sql,name,age);
    }
}
