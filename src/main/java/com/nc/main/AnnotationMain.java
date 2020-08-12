package com.nc.main;

import com.nc.config.JavaConfig;
import com.nc.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AnnotationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService = ctx.getBean("userService", UserService.class);
        List<String> allUser = userService.getAllUser();
        System.out.println(allUser);
    }
}
