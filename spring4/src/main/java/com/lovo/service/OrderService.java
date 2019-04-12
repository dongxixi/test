package com.lovo.service;

import com.lovo.bean.Order;

import java.util.List;

public interface OrderService {
    boolean addOrder(Order order);

    boolean delOrder(int id);

    boolean updateOrder(Order order);

    List<Order> getListOrder();
}
