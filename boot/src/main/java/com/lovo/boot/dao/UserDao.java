package com.lovo.boot.dao;

import com.lovo.boot.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, String> {
}
