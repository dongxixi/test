package com.lovo.service.impl;

import com.lovo.dao.UserDao;
import com.lovo.entity.UserEntity;
import com.lovo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<UserEntity> getUserList(int pageNo, int pageSize) {
        Pageable page = new PageRequest(pageNo, pageSize);
        Page<UserEntity> list = userDao.findAll(page);
        return list.getContent();
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        return userDao.save(userEntity) == null ? false : true;
    }

    @Override
    public void delUser(String id) {
        userDao.delete(id);
    }

    @Override
    public UserEntity getUser(String id) {
        return userDao.findOne(id);
    }
}
