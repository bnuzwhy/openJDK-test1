package com.why.juc.pc;

/**
 * 线程之间的通信问题：生产者和消费者问题
 * 线程交替执行 A  B 操作同一个变量   num=0
 * A num+1
 * B num-1
 */
public class C {
    public static void main(String[] args) {
        final Data3 data = new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
