package com.fundamentosplatzi.springboot.fundamentosplatzi.component;

import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class ComponentImplement implements ComponentDependency {

    @Override
    public void saludar() {
        System.out.println("Hello world from my component!!");
    }
}
