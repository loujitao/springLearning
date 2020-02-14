package com.steve.beanlifeCycl;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1321:24
 **/
public class Computer {
    /**
     * @Value 可以写哪些参数：
     * 1、基本数据类型，直接赋值（ 默认值）
     * 2、spEl表达式 #{}  表达式赋值给属性
     * 3、可以写${ }  取得spring加载了的配置文件中的值（也是从spring环境中取值）
     */
    @Value("intel")
    private String cpu;
    @Value("#{13-5}")
    private int  heshu;
    @Value("${computer.name}")
    private String name;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getHeshu() {
        return heshu;
    }

    public void setHeshu(int heshu) {
        this.heshu = heshu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", heshu=" + heshu +
                ", name='" + name + '\'' +
                '}';
    }
}
