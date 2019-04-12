package com.lovo.service.dao;

import com.lovo.service.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserDao extends CrudRepository<UserEntity, String > {

}
