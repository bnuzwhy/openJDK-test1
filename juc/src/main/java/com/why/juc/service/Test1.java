package com.why.juc.service;

public class Test1 {

    public static void main(String[] args) {
        //System.out.println(getAvailableProcessors());
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();
    }

    //获取cpu核心数
    public static int getAvailableProcessors() {
        final int i = Runtime.getRuntime().availableProcessors();
        return i;
    }
}
