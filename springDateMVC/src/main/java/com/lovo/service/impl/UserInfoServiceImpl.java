package com.lovo.service.impl;

import com.lovo.dao.UserInfoDao;
import com.lovo.entity.UserInfo;
import com.lovo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        return userInfoDao.save(userInfo) == null ? false : true;
    }

    @Override
    public List<UserInfo> getUserInfoList() {
        return (List<UserInfo>) userInfoDao.findAll();
    }

    @Override
    public List<UserInfo> getUserInfoByUserId(String id) {
        return userInfoDao.getUserInfoByUserId(id);
    }
}
