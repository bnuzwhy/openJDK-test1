package com.why.thread.syn;

class BuyTicket implements Runnable {

    private int ticketNum = 10;
    boolean flag = true;

    @Override
    public void run() {
        while(flag){
            buy();
        }
    }

    private synchronized void buy() {
        if(ticketNum<=0){
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNum--);
    }
}

public class UnsageBuyTicket{
    public static void main(String[] args) {
        BuyTicket ticket = new BuyTicket();
        new Thread(ticket,"AAA").start();
        new Thread(ticket,"BBB").start();
        new Thread(ticket,"CCC").start();
    }
}
