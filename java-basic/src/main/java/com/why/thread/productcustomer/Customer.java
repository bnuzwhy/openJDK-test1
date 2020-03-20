package com.why.thread.productcustomer;

public class Customer extends Thread {

    SynContainer container;
    public Customer(SynContainer container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->"+container.pull().id+"只鸡");
        }
    }
}
