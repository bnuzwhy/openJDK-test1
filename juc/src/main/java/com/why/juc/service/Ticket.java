package com.why.juc.service;

public class Ticket {
    private int number = 50;

    //卖票的方式
    public void sale(){
        if(number >0 ){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+number--+"张票，剩余："+number);
        }
    }
}
