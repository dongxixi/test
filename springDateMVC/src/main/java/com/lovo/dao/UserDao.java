package com.lovo.dao;

import com.lovo.entity.Role;
import com.lovo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserDao extends CrudRepository<User, String> {

//    @Query("select u from User u where u.name = ?1 and u.password = ?2")
//    int isTrue(User user);

    User findByNameAndPassword(String name, String password);

//    User findByNameAndAndPasswordAndRole(String name, String password, Role role);

    @Query("select r from Role r join User u where u.name = ?1 and u.password = ?2 and r.name = ?3")

    Role findByRoleName(String name, String password, String roleName);
}
