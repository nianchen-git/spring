package com.nc.dao;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addMoney(String username, Integer money){
        jdbcTemplate.update("update account set money=money+? where username=?",money,username);
    }

    public void minMoney(String username, Integer money){
        jdbcTemplate.update("update account set money=money-? where username=?",money,username);
    }











    public String hello(){
        return "hello-userDao";
    }
}
