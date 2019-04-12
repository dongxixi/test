package com.lovo.test;

public class ProxyTest {
    public static void main(String[] args) {
        SomeServiceImpl someService = new SomeServiceImpl();
        SomeServiceImpl proxy = (SomeServiceImpl) ProxyFactory.createProxy(someService);
        String str = proxy.dosome();
        System.out.println(str);
    }
}
