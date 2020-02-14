package com.steve.autoware;

import org.springframework.stereotype.Repository;

/**
 * @Description: TODO
 * @Author: SteveTao
 * @Date: 2020/2/1321:50
 **/
//bean的ID默认是类名   ADao
@Repository
public class ADao {
    private String id="100";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ADao{" +
                "id='" + id + '\'' +
                '}';
    }
}
