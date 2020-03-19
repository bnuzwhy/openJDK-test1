package com.why.lambda;

/**
 * 推倒lambda表达式
 * 2.使用静态内部类
 */
public class TestLambda2 {

    static class Like2 implements ILike2{

        @Override
        public void lambda() {
            System.out.println("I Like Lambda2");
        }
    }

    public static void main(String[] args) {
        ILike2 like = new Like2();
        like.lambda();
    }
}

//1.定义一个函数式接口
interface ILike2{
    void lambda();
}

