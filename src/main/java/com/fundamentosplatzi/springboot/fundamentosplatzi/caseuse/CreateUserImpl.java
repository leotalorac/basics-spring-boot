package com.fundamentosplatzi.springboot.fundamentosplatzi.caseuse;

import com.fundamentosplatzi.springboot.fundamentosplatzi.entity.User;
import com.fundamentosplatzi.springboot.fundamentosplatzi.service.UserService;

public class CreateUserImpl implements CreateUser{

    private UserService userService;

    public CreateUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User createUser(User user) {
        return userService.saveUser(user);
    }
}
