package com.why.lambda;

/**
 * 推倒lambda表达式
 * 4.使用匿名内部类
 */
public class TestLambda4 {

    public static void main(String[] args) {
        ILike4 like = new ILike4(){

            @Override
            public void lambda() {
                System.out.println("I Like Lambda4");
            }
        };
        like.lambda();
    }
}

//1.定义一个函数式接口
interface ILike4{
    void lambda();
}

