package com.lovo.bean;

public class Order {
    private int id;
    private int orderNumber;
    private int goodsId;
    private int orderNum;
    private double orderPrice;

    public Order() {
    }

    public Order(int id, int orderNumber, int goodsId, int orderNum, double orderPrice) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.goodsId = goodsId;
        this.orderNum = orderNum;
        this.orderPrice = orderPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", goodsId=" + goodsId +
                ", orderNum=" + orderNum +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
