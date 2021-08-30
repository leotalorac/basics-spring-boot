package com.fundamentosplatzi.springboot.fundamentosplatzi.configuration;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//Add configuration to add a bean
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
//        change the correct implementation
        return new MyBeanTwoImplement();
    }
    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }
    @Bean
    public MyBeanWithDependency beanOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
