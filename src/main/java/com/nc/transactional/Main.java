package com.nc.transactional;

import com.nc.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @Autowired
    UserService userService;
    @Test
    public void test(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = ctx.getBean(UserService.class);
        userService.updateMoney();
    }
}
