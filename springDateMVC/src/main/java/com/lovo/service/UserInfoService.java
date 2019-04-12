package com.lovo.service;

import com.lovo.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    boolean addUserInfo(UserInfo userInfo);

    List<UserInfo> getUserInfoList();

    List<UserInfo> getUserInfoByUserId(String id);
}
