package com.why.juc.lock8;

import java.util.concurrent.TimeUnit;

/*
 *8锁，就是8种锁的问题
 * 7.一个静态同步方法，一个普通同步方法，谁先打印？打电话先执行
 * 8.两个对象，一个静态同步方法，一个普通同步方法，谁先打印？打电话先执行
 */
public class Phone5 {
    public static synchronized void sendSms(){
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

    public void hello(){
        System.out.println("hello...");
    }
}
