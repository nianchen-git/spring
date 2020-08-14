package com.nc.aop;

import org.springframework.stereotype.Service;

@Service
public class MyCalculatorImpl {
    @Action
    public int add(int a, int b){
        System.out.println(a+"+"+b+"=" + (a+b));
        return a+b;
    }
    public int min(int a, int b){
        System.out.println(a+"-"+b+"=" + (a-b));
        return a-b;
    }
}
