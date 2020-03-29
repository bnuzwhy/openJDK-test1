package com.why.juc.lock8;

import java.util.concurrent.TimeUnit;

/*
 *8锁，就是8种锁的问题
 * 5.增加两个静态的同步方法，谁先执行？ 发短信先执行
 * 6.两个对象，两个静态的同步方法，谁先执行？ 发短信先执行
 * synchronized 锁的对象是方法调用者
 * static 静态方法，类一加载就有了。锁的是class
 * 类模板只有一个
 */
public class Phone4 {
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms...");
    }

    public static synchronized void call(){
        System.out.println("call...");
    }

    public void hello(){
        System.out.println("hello...");
    }
}
