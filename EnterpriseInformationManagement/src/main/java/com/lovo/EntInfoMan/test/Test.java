package com.lovo.EntInfoMan.test;

import com.lovo.EntInfoMan.bean.Address;
import com.lovo.EntInfoMan.dao.impl.AddressDaoImpl;

public class Test {
    public static void main(String[] args) {
        AddressDaoImpl ad = new AddressDaoImpl();
        for (int i = 1; i <= 100; i++) {
            Address a = new Address();
            a.setName("张三" + i);
            a.setSex(i / 3 == 0 ? "女" : "男");
            a.setMobile("" + (long)(Math.random() * 10000000000l));
            a.setEmail((int) (Math.random() * 1000) + "@qq.com");
            a.setQq("" + (long)(Math.random() * 100000000l));
            a.setCompany("lovo" + i);
            a.setAddress("成都");
            a.setPostcode(610000);
            ad.add(a);
        }
    }
}
