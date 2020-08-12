package com.nc.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ShowCmd showCmd = ctx.getBean("showCmd", ShowCmd.class);
        System.out.println(showCmd.showCmd());
    }
}
