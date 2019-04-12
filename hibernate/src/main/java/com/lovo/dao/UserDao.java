package com.lovo.dao;

import com.lovo.entity.UserEntity;

import java.util.List;

public interface UserDao {
    int add(UserEntity userEntity);

    int del(int id);

    int update(UserEntity userEntity);

    UserEntity get(int id);

    List<UserEntity> getList();

    int size();
}
