package com.why.spi;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class MainClass {
    public static void main(String[] args) {
        testSPI4JDBC();
    }

    public static void testSPI1(){

        //保存了我们的IParseDoc接口到service
        //保存我们classLoader----> 线程上类加载器（app）
        ServiceLoader<IParseDoc> iParseDocs = ServiceLoader.load(IParseDoc.class);

        //创建了一个懒加载的迭代器
        Iterator<IParseDoc> iParseDocIterator = iParseDocs.iterator();

        //读取我们的meta-inf/service/接口全类名
        while(iParseDocIterator.hasNext()){
            iParseDocIterator.next();
        }
    }

    public static void testSPI4JDBC(){
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);

        Iterator<Driver> iterator = loader.iterator();

        while(iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println("driver的class属性：{"+driver.getClass()+"}，类加载器：{"+driver.getClass().getClassLoader()+"}");
        }
    }
}
