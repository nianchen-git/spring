package com.nc.calculator;

public class Main {
    public static void main(String[] args) {
        MyCalculatorImpl myCalculator = new MyCalculatorImpl();
        System.out.println(myCalculator.add(3,5));
        MyCalculator myCalculator1 = (MyCalculator) CalculatorProxy.getInstance(myCalculator);
        System.out.println(myCalculator1.add(4,8));

    }
}
