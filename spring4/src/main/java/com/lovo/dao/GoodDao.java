package com.lovo.dao;

import com.lovo.bean.Good;

import java.util.List;

public interface GoodDao {
    int addGood(Good good);

    int delGood(int id);

    int updateGood(Good good);

    List<Good> getListGoods();

}
