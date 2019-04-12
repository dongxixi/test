package com.lovo.dao;

import com.lovo.bean.Order;

import java.util.List;

public interface OrderDao {
    int addOrder(Order order);

    int delOrder(int id);

    int updateOrder(Order order);

    List<Order> getListOrder();
}
