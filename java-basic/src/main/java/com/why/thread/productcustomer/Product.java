package com.why.thread.productcustomer;

public class Product extends Thread {
    SynContainer container;
    public Product(SynContainer container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
