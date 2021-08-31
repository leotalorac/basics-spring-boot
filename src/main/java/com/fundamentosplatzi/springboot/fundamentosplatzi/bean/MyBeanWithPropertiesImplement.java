package com.fundamentosplatzi.springboot.fundamentosplatzi.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{
    private String name,lastname;
    public MyBeanWithPropertiesImplement(String name, String lastname){
        this.name=name;
        this.lastname=lastname;
    }
    @Override
    public String function() {
        return this.name + " " +this.lastname;
    }
}
