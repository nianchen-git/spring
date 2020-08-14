package com.nc.config;

import com.nc.bean.SayHello;
import com.nc.bean.User;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
/*
* useDefaultFilters 是否使用默认的Filter扫描 默认位true，true与excludeFilters不扫描那些
* includeFilters与flase 光扫描哪些
*
* */
@Configuration
@ImportResource("classpath:applicationContext.xml")
@ComponentScan(basePackages = "com.nc.service")
@ComponentScan(basePackages = "com.nc", useDefaultFilters = true, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
public class JavaConfig {
    @Bean
    SayHello sayHello(){
        return new SayHello();
    }
    @Bean("小白")
    User getUser(){
        return new User();
    }
}
