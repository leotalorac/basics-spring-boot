package com.fundamentosplatzi.springboot.fundamentosplatzi.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hello world form my second component!!");
    }
}
