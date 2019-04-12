package com.lovo.service.impl;

import com.lovo.dao.UserDao;
import com.lovo.entity.User;
import com.lovo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovo.entity.Role;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        Iterable<User> all = userDao.findAll();
        return (List<User>) all;
    }

    @Override
    public boolean addUser(User user) {
        return userDao.save(user) == null ? false : true;
    }

    @Override
    public User findByNameAndPassword(String name, String password) {
        return userDao.findByNameAndPassword(name, password);
    }

    @Override
    public User findByRoleName(String name, String password, String roleName) {
        return userDao.findByRoleName(name, password, roleName).getUser();
    }
}