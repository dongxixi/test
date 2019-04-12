package com.lovo.service.controller;

import com.lovo.service.entity.UserEntity;
import com.lovo.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUserList")
    public UserEntity getUserList() {
        return userService.getUserList().get(0);
    }
}
