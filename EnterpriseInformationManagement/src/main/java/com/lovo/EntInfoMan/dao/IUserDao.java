package com.lovo.EntInfoMan.dao;

import com.lovo.EntInfoMan.bean.User;

public interface IUserDao {
    int login(User user);

    int register(User user);
}
