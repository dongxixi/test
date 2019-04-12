package com.lovo.EIM.service.impl;

import com.lovo.EIM.bean.Address;
import com.lovo.EIM.dao.AddressDao;
import com.lovo.EIM.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

public class AddressServiceImpl implements AddressService {

//    @Resource(name = "addressDao")
    AddressDao ad;

    public void setAd(AddressDao ad) {
        this.ad = ad;
    }

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

        return ad.getlist((pageNo - 1) * pageSize < 0 ? 0 : (pageNo - 1) * pageSize, pageSize);
    }

//    @Override
//    public Address getAdderss(int id) {
//        return ad.getAdderss(id);
//    }

    @Override
    public int getTotalNum() {
        return ad.getTotalNum();
    }

    @Override
    public boolean del(int id) {
        return ad.del(id) >= 1 ? true : false;
    }
}
