package com.fundamentosplatzi.springboot.fundamentosplatzi.configuration;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springboot.fundamentosplatzi.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;
    @Value("${value.lastname}")
    private String lastname;
    @Value("${value.random}")
    private String random;

    @Value("${jbdc.url}")
    private String url;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String user;

    @Value("${password}")
    private String pass;


    @Bean
    public MyBeanWithProperties function(){
        return  new MyBeanWithPropertiesImplement(name,lastname);
    }

    @Bean
    //Manual configuration data source
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(pass);
        return dataSourceBuilder.build();
    }
}
