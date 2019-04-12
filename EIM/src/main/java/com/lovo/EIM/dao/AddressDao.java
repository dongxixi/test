package com.lovo.EIM.dao;

import com.lovo.EIM.bean.Address;

import java.util.List;

public interface AddressDao {
    int add(Address address);

    int updata(Address address);

    List<Address> getlist(int pageNo, int pageSize);

//    Address getAdderss(int id);

    int getTotalNum();

    int del(int id);
}
