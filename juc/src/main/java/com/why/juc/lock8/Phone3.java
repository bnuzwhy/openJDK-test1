package com.why.juc.lock8;

import java.util.concurrent.TimeUnit;

/*
 *8锁，就是8种锁的问题
 * 4.两个对象，两个同步方法，谁先执行？ 打电话先执行
 */
public class Phone3 {
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

    public void hello(){
        System.out.println("hello...");
    }
}
