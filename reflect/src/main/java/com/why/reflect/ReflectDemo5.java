package com.why.reflect;

import com.why.domain.Person;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo5 {
    public static void main(String[] args) throws Exception {
        //需求：不改变该类的任何代码，可以创建任意类的对象，可以执行任意方法

        //1.加载配置文件
        //1.1创建Properties对象
        Properties pro = new Properties();
        //1.2加载配置文件，转换为一个集合
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = ReflectDemo5.class.getClassLoader();
        System.out.println("aa  "+classLoader);
        InputStream resourceAsStream = classLoader.getResourceAsStream("a.properties");
        pro.load(resourceAsStream);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class<?> aClass = Class.forName(className);
        //4.创建对象
        Object o = aClass.newInstance();
        //获取方法对象
        Method method = aClass.getMethod(methodName);
        //执行方法
        method.invoke(o);

    }
}
