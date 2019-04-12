package com.lovo.dao;

import com.lovo.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserInfoDao extends CrudRepository<UserInfo, String> {

    @Query("select i from UserInfo i join i.user u where u.id=?1")
    List<UserInfo> getUserInfoByUserId(String id);
}
