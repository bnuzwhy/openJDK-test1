package com.why.proxy;

/**
 * 静态代理模式
 */
public class StaticProxy1 {
    public static void main(String[] args) {
        ProxyMe me = new ProxyMe(new Me());
        System.out.println("起床");
        me.eat();
        System.out.println("运动");
        me.sleep();
    }
}

interface Person{
    void eat();
    void sleep();
}

class Me implements Person{
    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("睡觉");
    }
}

class ProxyMe implements Person{
    private Me me;
    public ProxyMe(Me me){
        this.me = me;
    }
    @Override
    public void eat() {
        this.me.eat();
    }
    @Override
    public void sleep() {
        this.me.sleep();
    }
}

