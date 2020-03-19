package com.why.lambda;

/**
 * 推倒lambda表达式
 * 1.传统方式
 */
public class TestLambda1 {
    public static void main(String[] args) {
        ILike1 like = new Like1();
        like.lambda();
    }
}

//1.定义一个函数式接口
interface ILike1{
    void lambda();
}

class Like1 implements ILike1{
    @Override
    public void lambda() {
        System.out.println("I like Lambda");
    }
}
