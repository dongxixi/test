package com.lovo.test;

import com.lovo.bean.Good;
import com.lovo.service.GoodService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext app = null;

        app = new ClassPathXmlApplicationContext("applicationContext.xml");

        GoodService goodService = (GoodService) app.getBean("goodService");

        Good good = new Good();
        good.setGoodName("MI9");
        good.setGoodNum(90);

        boolean b = goodService.addGood(good);
        System.out.println(b);
    }

}
