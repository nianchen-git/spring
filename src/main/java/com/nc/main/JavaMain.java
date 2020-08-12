package com.nc.main;

import com.nc.bean.SayHello;
import com.nc.bean.User;
import com.nc.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext crx = new AnnotationConfigApplicationContext(JavaConfig.class);
        SayHello sayHello = crx.getBean(SayHello.class);
        System.out.println(sayHello.sayhello("小白"));
        User user = crx.getBean("小白", User.class);
        System.out.println(user);

    }
}
