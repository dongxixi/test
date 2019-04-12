package com.lovo.EntInfoMan.service;

import com.lovo.EntInfoMan.bean.Address;

import java.util.List;

public interface AddressService {
    boolean add(Address address);

    boolean updata(Address address);

    List<Address> getlist(int pageNo, int pageSize);

//    Address getAdderss(int id);

    int getTotalNum();

    boolean del(int id);
}
