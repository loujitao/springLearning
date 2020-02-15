package com.steve.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: TODO
 * @Author: SteveTao
 * @Date: 2020/2/1514:46
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insert( ){
        userDao.insert();
        System.out.println("执行完插入操作");
        //其他业务操作。。。
        // 测试异常时，事务是否能够回滚
        int a=10/0;
    }
}
