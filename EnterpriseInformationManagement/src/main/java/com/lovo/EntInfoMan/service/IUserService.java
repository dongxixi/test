package com.lovo.EntInfoMan.service;

import com.lovo.EntInfoMan.bean.User;

public interface IUserService {
    boolean login(User user);

    boolean register(User user);
}
