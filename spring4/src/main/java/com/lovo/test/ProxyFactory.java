package com.lovo.test;

import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {
    public static final Object createProxy(Object object) {
        Enhancer en = new Enhancer();
        en.setSuperclass(SomeServiceImpl.class);
        en.setCallback(new MyInterceptor(object));
        return en.create();
    }
}
