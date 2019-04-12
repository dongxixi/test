package com.lovo.service;

import com.lovo.entity.User;

import com.lovo.entity.Role;
import java.util.List;

public interface UserService {

    List<User> getUserList();

    boolean addUser(User user);

    User findByNameAndPassword(String name, String password);

//    User findByNameAndAndPasswordAndRole(String name, String password, Role role);

    User findByRoleName(String name, String password, String roleName);
}
