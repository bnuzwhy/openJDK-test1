package com.why.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程休眠
 * 每一个对象都有一把锁，sleep不会释放锁
 */
public class _03_TestSleep2 {
    public static void main(String[] args) {
        //tenDown();
        getCurrentTime();

    }

    //打印当前时间
    public static void getCurrentTime(){
        Date startDate = new Date(System.currentTimeMillis());//获取当前系统的时间
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startDate));
                startDate = new Date(System.currentTimeMillis());//获取当前系统的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //模拟倒计时
    public static void tenDown(){
        int num = 10;
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(num--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(num<=0){
                break;
            }
        }
    }
}
