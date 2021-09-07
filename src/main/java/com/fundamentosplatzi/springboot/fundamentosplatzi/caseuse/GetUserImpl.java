package com.fundamentosplatzi.springboot.fundamentosplatzi.caseuse;

import com.fundamentosplatzi.springboot.fundamentosplatzi.entity.User;
import com.fundamentosplatzi.springboot.fundamentosplatzi.service.UserService;

import java.util.List;

public class GetUserImpl implements GetUser{

    UserService userService;

    public GetUserImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
