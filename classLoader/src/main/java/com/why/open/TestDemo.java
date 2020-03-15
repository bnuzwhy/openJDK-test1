package com.why.open;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 看源码
 * 双清委派原则
 * 线程加载上下文
 * 打破双清委派
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        //Thread.currentThread().setContextClassLoader(TestDemo.class.getClassLoader().getParent());

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","wanghongyu");
    }
}
