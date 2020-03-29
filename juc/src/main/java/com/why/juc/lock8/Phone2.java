package com.why.juc.lock8;

import java.util.concurrent.TimeUnit;

/*
 *8锁，就是8种锁的问题
 * 3.增加了一个普通方法hello(),谁先执行？  hello()先执行
 */
public class Phone2 {
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
