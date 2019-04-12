package com.lovo.EntInfoMan.service.impl;

import com.lovo.EntInfoMan.bean.User;
import com.lovo.EntInfoMan.dao.UserDao;
import com.lovo.EntInfoMan.dao.impl.UserDaoImpl;
import com.lovo.EntInfoMan.service.IUserService;

public class UserServiceImpl implements IUserService {

    UserDao ud = new UserDaoImpl();

    @Override
    public boolean login(User user) {
        return ud.login(user) >= 1 ? true : false;
    }

    @Override
    public boolean register(User user) {
        return ud.register(user) >= 1 ? true : false;
    }
}
