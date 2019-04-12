package com.lovo.EIM.service.impl;

import com.lovo.EIM.bean.User;
import com.lovo.EIM.dao.UserDao;
import com.lovo.EIM.service.UserService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    UserDao ud;

    public boolean login(User user) {
        return ud.login(user) >= 1 ? true : false;
    }

    public boolean register(User user) {
        return ud.register(user) >= 1 ? true : false;
    }

}
