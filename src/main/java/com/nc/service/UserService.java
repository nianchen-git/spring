package com.nc.service;

import com.nc.bean.Book;
import com.nc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
//    @Resource(type = Book.class)
//    @Resource(name = "book2")
    @Autowired      //默认首个找到的
    @Qualifier("book3")
    Book book;
    public List<String> getAllUser(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("小白："+i);
        }
        return list;
    }
    public String hello(){
        return userDao.hello();
    }
    public Book getBook(){
        return book;
    }
}
