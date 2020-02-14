package com.steve.autoware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: SteveTao
 * @Date: 2020/2/1321:50
 **/
@Service
public class AService {

    @Qualifier("ADao")
    @Autowired(required = false)
    private ADao ADao;

    @Override
    public String toString() {
        return "AService{" +
                "aDao=" + ADao +
                '}';
    }
}
