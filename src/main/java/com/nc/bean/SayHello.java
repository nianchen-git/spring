package com.nc.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SayHello implements ApplicationContextAware {
    private ApplicationContext context;
    public String sayhello(String name){
        Boolean userDao = context.containsBean("userDao");
        System.out.println(userDao);
        return "hello"+name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
