package com.lovo.test;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyInterceptor implements MethodInterceptor {

    public MyInterceptor() {
    }

    public MyInterceptor(Object ss) {
        this.ss = ss;
    }

    private Object ss;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("=========intercept=========");

        Object result = method.invoke(ss, objects);

        return result;
    }
}
