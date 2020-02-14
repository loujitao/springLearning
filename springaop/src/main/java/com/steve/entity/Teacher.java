package com.steve.entity;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1315:19
 **/
public class Teacher {
    private String name;
    private String kemu;

    public Teacher() {
    }

    public Teacher(String name, String kemu) {
        this.name = name;
        this.kemu = kemu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", kemu='" + kemu + '\'' +
                '}';
    }
}
