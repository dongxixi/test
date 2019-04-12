package com.lovo.bean;

public class Good {
    private int id;
    private String goodName;
    private int goodNum;

    public Good() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public Good(int id, String goodsName, int goodsNum) {
        this.id = id;
        this.goodName = goodsName;
        this.goodNum = goodsNum;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", goodNum=" + goodNum +
                '}';
    }
}
