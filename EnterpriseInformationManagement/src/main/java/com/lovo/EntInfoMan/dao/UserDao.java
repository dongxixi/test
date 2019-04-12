package com.lovo.EntInfoMan.dao;

import com.lovo.EntInfoMan.bean.User;

public interface UserDao {
    int login(User user);

    int register(User user);
}
