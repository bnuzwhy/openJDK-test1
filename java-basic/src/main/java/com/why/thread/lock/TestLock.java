package com.why.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}

class Ticket implements Runnable{
    int ticketNum = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try {
                lock.lock();
                if (ticketNum > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNum--);
                } else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
