package com.lovo.EIM.dao;

import com.lovo.EIM.bean.User;

public interface UserDao {
    int login(User user);

    int register(User user);
}
