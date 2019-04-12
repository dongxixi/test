package com.lovo.boot.service.impl;

import com.lovo.boot.dao.UserDao;
import com.lovo.boot.entity.UserEntity;
import com.lovo.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(UserEntity userEntity) {
        return userDao.save(userEntity) == null ? false : true;
    }

    @Override
    public List<UserEntity> getList() {
        return (List<UserEntity>) userDao.findAll();
    }
}
