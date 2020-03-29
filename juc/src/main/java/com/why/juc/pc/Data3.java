package com.why.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Data3 {
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition4 = lock.newCondition();

    public void increment(int i) throws InterruptedException {
        try {
            lock.lock();

            while (number != 0) {
                //等待
                if(i == 1) {
                    condition1.await();
                }else{
                    condition3.await();
                }
            }
            number++;
            System.out.println(Thread.currentThread().getName() + " -> 1");
            //通知其他线程，我+1完成了
            if(i == 1) {
                condition2.signal();
            }else{
                condition4.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(int i) throws InterruptedException {

        try {
            lock.lock();
            while (number == 0) {
                //等待
                if(i == 2) {
                    condition2.await();
                }else{
                    condition4.await();
                }
            }
            number--;
            System.out.println(Thread.currentThread().getName() + " -> 0");
            //通知其他线程，我-1完成了
            if(i == 2) {
                condition3.signal();
            }else{
                condition1.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
