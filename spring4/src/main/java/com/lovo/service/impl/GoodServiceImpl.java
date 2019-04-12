package com.lovo.service.impl;

import com.lovo.bean.Good;
import com.lovo.dao.GoodDao;
import com.lovo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("goodService")
public class GoodServiceImpl implements GoodService {

    @Autowired
    GoodDao goodDao;

    @Override
    public boolean addGood(Good good) {
        return goodDao.addGood(good) > 0 ? true : false;
    }

    @Override
    public boolean delGood(int id) {
        return goodDao.delGood(id) > 0 ? true : false;
    }

    @Override
    public boolean updateGood(Good good) {
        return goodDao.updateGood(good) > 0 ? true : false;
    }

    @Override
    public List<Good> getListGoods() {
        return goodDao.getListGoods();
    }
}
