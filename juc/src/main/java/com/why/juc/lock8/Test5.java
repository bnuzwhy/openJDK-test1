package com.why.juc.lock8;

import java.util.concurrent.TimeUnit;

public class Test5 {
    public static void main(String[] args) {
        Phone5 phone = new Phone5();
        new Thread(()->{
            Phone4.sendSms();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            Phone4.call();
        },"B").start();
    }
}
