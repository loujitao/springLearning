package com.steve.entity;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1315:16
 **/
public class Student {
    private String name ;
    private int age;
    private int number;
    private String address;

    public Student( ) {
    }

    public Student(String name, int age, int number, String address) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", address='" + address + '\'' +
                '}';
    }
}
