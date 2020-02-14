package com.steve.beanlifeCycl;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1315:49
 **/
public class Something {
    public Something() {
        System.out.println("something 构造方法。。。");
    }

    public void init(){
        System.out.println("Something init method ....");
    }

    public void destory(){
        System.out.println( "Something destory method ...");
    }

}
