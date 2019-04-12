package com.lovo.service.service.impl;

import com.lovo.service.dao.UserDao;
import com.lovo.service.entity.UserEntity;
import com.lovo.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public List<UserEntity> getUserList() {
        return (List<UserEntity>) userDao.findAll();
    }
}
