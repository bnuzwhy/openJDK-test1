package com.why.interfaceupgrade;

public interface Demo01 {
    void test01();
}

interface AA{
    public default void test01(){
        System.out.println("我是接口AA的默认方法");
    }
}

class BB implements Demo01{

    @Override
    public void test01() {
        CC cc = new CC();
        cc.test01();
    }
}

class CC implements AA{
    public static void main(String[] args) {
        new BB().test01();
    }
}



