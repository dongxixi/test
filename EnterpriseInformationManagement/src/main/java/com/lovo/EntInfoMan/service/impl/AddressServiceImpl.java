package com.lovo.EntInfoMan.service.impl;

import com.lovo.EntInfoMan.bean.Address;
import com.lovo.EntInfoMan.dao.IAddressDao;
import com.lovo.EntInfoMan.dao.impl.AddressDaoImpl;
import com.lovo.EntInfoMan.service.IAddressService;

import java.util.List;

public class AddressServiceImpl implements IAddressService {

    IAddressDao ad = new AddressDaoImpl();

    @Override
    public boolean add(Address address) {
        return ad.add(address) >= 1 ? true : false;
    }

    @Override
    public boolean updata(Address address) {
        return ad.updata(address) >= 1 ? true : false;
    }

    @Override
    public List<Address> getlist(int pageNo, int pageSize) {
        return ad.getlist(pageNo, pageSize);
    }

    @Override
    public Address getAdderss(int id) {
        return ad.getAdderss(id);
    }

    @Override
    public int getTotalNum() {
        return ad.getTotalNum();
    }

    @Override
    public boolean del(int id) {
        return ad.del(id) >= 1 ? true : false;
    }
}
