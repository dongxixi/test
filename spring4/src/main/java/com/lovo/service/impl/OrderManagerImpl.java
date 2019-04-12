package com.lovo.service.impl;

import com.lovo.bean.Good;
import com.lovo.bean.Order;
import com.lovo.dao.GoodDao;
import com.lovo.dao.OrderDao;
import com.lovo.service.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service("orderManager")
public class OrderManagerImpl implements OrderManager {

    @Autowired
    OrderDao orderDao;
    @Autowired
    GoodDao goodDao;

//    @Transactional(value = "transactionManager")
    @Override
    public boolean addOrder(Order order) {

        int flag = orderDao.addOrder(order);

        if (flag > 0) {
            Good good = new Good();
            good.setId(order.getGoodsId());
            List<Good> listGoods = goodDao.getListGoods();
            for (Good listGood : listGoods) {
                if (listGood.getId() == order.getGoodsId()) {
                    good.setGoodNum(listGood.getGoodNum());
                }
            }
            good.setGoodNum(good.getGoodNum() - order.getOrderNum());

            int i = goodDao.updateGood(good);
            if (i <= 0) {
                throw new RuntimeException("删除库存错误");
            }
        } else {
            throw new RuntimeException("添加订单错误");
        }
        return false;
    }
}
