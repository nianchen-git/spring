package com.nc.main;

import com.nc.bean.Book;
import com.nc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        System.out.println(userService.getAllUser());
        System.out.println(userService.hello());
        System.out.println(userService.getBook());
    }

}
