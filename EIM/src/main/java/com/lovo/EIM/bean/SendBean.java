package com.lovo.EIM.bean;

import java.util.List;

public class SendBean {
    private int pagetotal;
    private List<Address> list;

    public SendBean() {
    }

    public SendBean(int pagetotal, List<Address> list) {
        this.pagetotal = pagetotal;
        this.list = list;
    }

    public int getPagetotal() {
        return pagetotal;
    }

    public void setPagetotal(int pagetotal) {
        this.pagetotal = pagetotal;
    }

    public List<Address> getList() {
        return list;
    }

    public void setList(List<Address> list) {
        this.list = list;
    }
}
