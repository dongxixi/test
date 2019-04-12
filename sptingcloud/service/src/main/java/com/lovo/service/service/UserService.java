package com.lovo.service.service;

import com.lovo.service.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity addUser(UserEntity userEntity);

    List<UserEntity> getUserList();
}
