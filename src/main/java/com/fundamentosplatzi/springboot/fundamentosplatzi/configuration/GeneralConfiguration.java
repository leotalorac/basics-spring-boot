package com.fundamentosplatzi.springboot.fundamentosplatzi.configuration;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springboot.fundamentosplatzi.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;
    @Value("${value.lastname}")
    private String lastname;
    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return  new MyBeanWithPropertiesImplement(name,lastname);
    }
}