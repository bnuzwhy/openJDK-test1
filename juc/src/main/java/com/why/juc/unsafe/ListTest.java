package com.why.juc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

//java.util.ConcurrentModificationException 并发修改异常！
public class ListTest {
    public static void main(String[] args) {
        testList1();
    }

    public static void testList1() {
        /*
        并发下 ArrayList不安全
        解决方案：
            1.List<String> list = new Vector<>();  Synchronized  java1.0 就出现了，效率低
            2.List<String> list = Collections.synchronizedList(new ArrayList<>());
            3.List<String> list = new CopyOnWriteArrayList<>();  使用lock锁，效率更高

        CopyOnWrite 写入时复制   COW 计算机程序设计领域的一种优化策略
        多个线程调用的时候，list读取的时候，固定的，写入（覆盖）
        在写入的时候避免覆盖，造成数据问题
        读写分离  （java层面）
        CopyOnWriteArrayList 比Vector 牛逼在哪？
         */
        //List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
