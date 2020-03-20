package com.why.thread;

/**
 * 守护线程
 * 线程分为用户线程（main）和守护线程（gcc）
 * 虚拟机必须确保用户线程执行完毕
 * 虚拟机不用等待守护线程执行完毕
 */
public class _08_TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认是false表示用户线程，正常的线程都是用户线程
        thread.start();

        new Thread(you).start();
    }
}

//上帝，守护线程
class God implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("上帝保佑着你 ！");
        }
    }
}

//你，用户线程
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心的活着");
        }
        System.out.println("=====GoodBye, World !=====");
    }
}
