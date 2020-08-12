package com.nc.main;

import com.nc.bean.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BookMain {
    public static void main(String[] args) {
//        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("D:\\StudyTest\\spring\\src\\main\\resources\\applicationContext.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = ctx.getBean("book", Book.class);
//        Book book = (Book) ctx.getBean("book4");
        System.out.println(book);
    }
}
