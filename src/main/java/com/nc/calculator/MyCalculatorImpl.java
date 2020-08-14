package com.nc.calculator;

public class MyCalculatorImpl implements MyCalculator {
    @Override
    public int add(int a, int b) {
        System.out.println(a+ "+" +b );
        return a+b;
    }
}
