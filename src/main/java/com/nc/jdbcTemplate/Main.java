package com.nc.jdbcTemplate;

import com.nc.bean.User;
import com.nc.bean.UserSql;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private JdbcTemplate jdbcTemplate;

    @Before
    public void befor(){
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
    }

    @Test
    public void insert(){
        jdbcTemplate.update("insert into user (id,username,address) values(?,?,?);","1","小白","河北");
    }

    @Test
    public void update(){
        jdbcTemplate.update("update user set address=?, username=? where id=?","南通","大白","1");
    }

    @Test
    public void delete(){
        jdbcTemplate.update("delete from user where id=?","1");
    }

    @Test
    public void query(){
        UserSql userSql = jdbcTemplate.queryForObject("select id,username,address from user where id=?", new BeanPropertyRowMapper<UserSql>(UserSql.class),"2");
        System.out.println(userSql);
    }

    @Test
    public void query2(){
        User user = jdbcTemplate.queryForObject("select * from user where id=?", new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                User user = new User();
                user.setId(id);
                user.setName(name);
                return user;
            }
        },2);
        System.out.println(user);
    }
    @Test
    public void queryAll(){
        List<UserSql> userList = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(UserSql.class));
        System.out.println(userList);
    }
}
