package com.lovo.dao;

import java.util.List;

public interface UserPowerDao {
    List<String> getPowerListByUserName(String userName);
}
