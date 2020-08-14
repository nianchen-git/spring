package com.nc.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//基于JDK的动态代理
public class CalculatorProxy {
    public static Object getInstance(final MyCalculator myCalculator){
        return Proxy.newProxyInstance(CalculatorProxy.class.getClassLoader(), myCalculator.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName()+"开始执行了......");
                Object invoke = method.invoke(myCalculator, args);
                System.out.println(method.getName()+"执行完毕......");
                return invoke;
            }
        });
    }
}
