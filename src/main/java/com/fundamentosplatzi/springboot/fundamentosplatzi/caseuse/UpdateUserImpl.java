package com.fundamentosplatzi.springboot.fundamentosplatzi.caseuse;

import com.fundamentosplatzi.springboot.fundamentosplatzi.entity.User;
import com.fundamentosplatzi.springboot.fundamentosplatzi.service.UserService;

public class UpdateUserImpl implements UpdateUser{

    private UserService userService;

    public UpdateUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void updateUser(Long id,User user) {
        userService.updateUser(id,user);
    }
}
