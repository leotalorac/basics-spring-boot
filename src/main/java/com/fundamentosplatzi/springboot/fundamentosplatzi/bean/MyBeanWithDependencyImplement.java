package com.fundamentosplatzi.springboot.fundamentosplatzi.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation){
        this.myOperation=myOperation;
    }

    @Override
    public void printWithDependency() {
        int number =1;
        System.out.println(myOperation.sum(number));
        System.out.println("Hello from a bean with dependency implementation");
    }
}
