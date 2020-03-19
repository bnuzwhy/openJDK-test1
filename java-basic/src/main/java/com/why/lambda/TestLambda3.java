package com.why.lambda;

/**
 * 推倒lambda表达式
 * 3.使用局部内部类
 */
public class TestLambda3 {

    public static void main(String[] args) {

        class Like3 implements ILike3{
            @Override
            public void lambda() {
                System.out.println("I Like Lambda2");
            }
        }
        ILike3 like = new Like3();
        like.lambda();
    }
}

//1.定义一个函数式接口
interface ILike3{
    void lambda();
}

