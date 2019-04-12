package com.lovo.boot.service;

import com.lovo.boot.entity.UserEntity;

import java.util.List;

public interface UserService {

    boolean addUser(UserEntity userEntity);

    List<UserEntity> getList();
}
