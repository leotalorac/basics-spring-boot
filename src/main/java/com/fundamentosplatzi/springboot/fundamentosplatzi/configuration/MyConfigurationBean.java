package com.fundamentosplatzi.springboot.fundamentosplatzi.configuration;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanImplement;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanTwoImplement;
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
}
