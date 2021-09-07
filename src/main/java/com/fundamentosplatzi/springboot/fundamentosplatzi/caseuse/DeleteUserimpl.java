package com.fundamentosplatzi.springboot.fundamentosplatzi.caseuse;

import com.fundamentosplatzi.springboot.fundamentosplatzi.entity.User;
import com.fundamentosplatzi.springboot.fundamentosplatzi.service.UserService;

public class DeleteUserimpl implements DeleteUser {
    private UserService userService;

    public DeleteUserimpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void deleteUser(Long id) {
        this.userService.deleteUser(id);
    }
}
