package com.why.lambda;

/**
 * 推倒lambda表达式
 * 5.使用Lambda表达式
 */
public class TestLambda5 {

    public static void main(String[] args) {
        ILike5 like = () -> System.out.println("I Like Lambda4");
        like.lambda();
    }
}

//1.定义一个函数式接口
interface ILike5{
    void lambda();
}

