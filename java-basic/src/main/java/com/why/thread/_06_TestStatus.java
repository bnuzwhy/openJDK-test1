package com.why.thread;

/**
 * 线程状态
 * NEW              尚未启动的线程
 * RUNNABLE         java虚拟机中执行的线程
 * BLOCKED          被阻塞等待监视器锁定的线程
 * WAITING          正在等待另一个线程执行特定动作的线程
 * TIMED WAITING    正在等待另一个线程执行动作达到指定的等待时间的线程
 * TERMINATED       已退出的线程
 *
 * 注：死亡的线程是不能重新启动的
 */
public class _06_TestStatus {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////");
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.println(state);

        while(true){
            if(state != Thread.State.TERMINATED){
                state = thread.getState();
                System.out.println(state);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //System.out.println();
    }
}
