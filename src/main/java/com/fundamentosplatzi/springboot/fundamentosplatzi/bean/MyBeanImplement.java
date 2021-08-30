package com.fundamentosplatzi.springboot.fundamentosplatzi.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Hello from my own Bean implementation");
    }
}
