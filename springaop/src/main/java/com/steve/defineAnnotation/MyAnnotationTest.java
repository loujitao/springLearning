package com.steve.defineAnnotation;

import java.lang.annotation.*;

/**
 * @Description: TODO
 * @Author: 自定义注解测试类
 * @Date: 2020/2/1215:45
 **/
public class MyAnnotationTest {

    @Annotation01(age = 1)
    public void test01(){
    }
}

//该注解将保留到Javadoc中
@Documented
//表示子类可以继承该注解
@Inherited()
//表示该注解可以在那些情况下使用   常用元注解
@Target({ElementType.METHOD,ElementType.TYPE})
//注解的生命周期     常用元注解
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation01{
    //注解里只有参数。 定义方式为：
    // 类型 + 名称( ) [ defalult  默认值 ]；
    String value() default "";
    int age();
}