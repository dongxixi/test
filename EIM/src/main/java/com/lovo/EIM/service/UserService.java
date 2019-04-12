package com.lovo.EIM.service;

import com.lovo.EIM.bean.User;

public interface UserService {
    boolean login(User user);

    boolean register(User user);
}
