package com.why.thread.productcustomer;

public class SynContainer {
    Chicken[] chickens = new Chicken[10];
    int count = 0;//容器计数器
    public synchronized void push(Chicken chicken){
        //如果容器满了，需要等待消费者消费
        if(count == chickens.length){
            //通知消费者，生产等待
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，就放入产品
        chickens[count] = chicken;
        count++;

        //可以通知消费者消费
        this.notifyAll();
    }

    //消费者消费
    public synchronized Chicken pull(){
        //判断能否消费
        if(count == 0){
            //等待生产者生产
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Chicken chicken = chickens[count];
        //吃完了，通知生产者生产
        this.notifyAll();

        return chicken;
    }
}
