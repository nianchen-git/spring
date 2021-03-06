package com.nc.profile;

import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:applicationContext.xml")//引入xml
public class JavaConfig {
    @Bean("ds")
    @Profile("dev")
    @Scope("prototype")//不单例
    DataSource devDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setName("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/dev");
        return dataSource;
    }

    @Bean("ds")
    @Profile("prod")
    DataSource prodDataSource(){
        DataSource dataSource = new DataSource();

        dataSource.setUrl("jdbc:mysql://192.168.21.1:3306/dev");
        dataSource.setName("admin");
        dataSource.setPassword("admin");

        return dataSource;
    }
}
