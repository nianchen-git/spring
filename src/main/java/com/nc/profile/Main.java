package com.nc.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        javaMain();
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("linux");
        ctx.setConfigLocation("applicationContext.xml");
        ctx.refresh();
        DataSource ds = ctx.getBean("dataSource", DataSource.class);
        System.out.println(ds);
    }

    private static void javaMain() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(JavaConfig.class);
        ctx.refresh();
        DataSource ds = ctx.getBean("ds", DataSource.class);
        System.out.println(ds);
    }
}
