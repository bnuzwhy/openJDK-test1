package com.why.thread;

/**
 * 模拟网络延时 : 放大问题的发生性
 */
public class TestSleep1 implements Runnable{

    private int ticketNums = 10;

    @Override
    public void run() {
        while(true){
            if(ticketNums<=0){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestSleep1 ticket = new TestSleep1();
        new Thread(ticket,"AAA").start();
        new Thread(ticket,"BBB").start();
        new Thread(ticket,"CCC").start();
    }
}
