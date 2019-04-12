package com.lovo.service;

import com.lovo.bean.Good;

import java.util.List;

public interface GoodService {
    boolean addGood(Good good);

    boolean delGood(int id);

    boolean updateGood(Good good);

    List<Good> getListGoods();
}
