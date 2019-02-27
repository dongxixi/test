package com.lovo.EntInfoMan.dao;

import com.lovo.EntInfoMan.bean.Address;

import java.util.List;

public interface IAddressDao {
    int add(Address address);

    int updata(Address address);

    List<Address> getlist(int pageNo, int pageSize);

    Address getAdderss(int id);

    int getTotalNum();

    int del(int id);
}
