package com.why.juc.pc;

public class Data {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        while(number != 0){
            //等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+" -> 1");
        //通知其他线程，我+1完成了
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while(number == 0){
            //等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+" -> 0");
        //通知其他线程，我-1完成了
        this.notifyAll();
    }
}
