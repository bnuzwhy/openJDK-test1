package com.why.juc.lock8;

import java.util.concurrent.TimeUnit;

/*
 *8锁，就是8种锁的问题
 * 1.标准情况下，两个线程先打印 发短信还是打电话   发短信先打印
 * 2.sendSms延迟4秒，两个线程谁先打印？发短信还是打电话  发短信先打印
 *
 * synchronize锁的对象是方法的调用者，
 * 两个方法用的是同一个锁，谁先拿到锁，谁先执行。
 */
public class Phone1 {
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms...");
    }

    public synchronized void call(){
        System.out.println("call...");
    }
}
