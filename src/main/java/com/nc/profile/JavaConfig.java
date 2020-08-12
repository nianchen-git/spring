package com.nc.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class JavaConfig {
    @Bean("ds")
    @Profile("dev")
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
