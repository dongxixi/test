package com.lovo.service.impl;

import com.lovo.bean.Order;
import com.lovo.dao.OrderDao;
import com.lovo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
    OrderDao orderDao;

    @Override
    public boolean addOrder(Order order) {
        return orderDao.addOrder(order) > 0 ? true : false;
    }

    @Override
    public boolean delOrder(int id) {
        return orderDao.delOrder(id) > 0 ? true : false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDao.updateOrder(order) > 0 ? true : false;
    }

    @Override
    public List<Order> getListOrder() {
        return orderDao.getListOrder();
    }
}
