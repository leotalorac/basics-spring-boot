package com.fundamentosplatzi.springboot.fundamentosplatzi.configuration;

import com.fundamentosplatzi.springboot.fundamentosplatzi.caseuse.*;
import com.fundamentosplatzi.springboot.fundamentosplatzi.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImpl(userService);
    }

    @Bean
    CreateUser createUser(UserService userService){
        return new CreateUserImpl(userService);
    }

    @Bean
    DeleteUser deleteUser(UserService userService){
        return new DeleteUserimpl(userService);
    }
    @Bean
    UpdateUser updateUser(UserService userService){
        return new UpdateUserImpl(userService);
    }


}
