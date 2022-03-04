package com.lang.springboot.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;


@Scope("prototype")
public class SomeBean {

    @Autowired
    private OtherBean otherBean;


    private void init() {
        System.out.println("init...");
    }

    public void doWork() {
        System.out.println("do work...");
    }

    private void destroy() {
        System.out.println("destroy...");
    }

    public void sayHello() {
        System.out.println(otherBean);
    }

}