package com.why.lambda;

/**
 * Lambda的标准格式：
 * Lambda表达式是一个匿名函数，而函数相当于java中方法
 *
 * (参数列表) -> {
 *     方法体;
 * }
 *
 */
public class Demo02 {
    public static void main(String[] args) {
        test1();
        test2();
    }
    /**
     * 1. 练习无参数无返回值的Lambda
     */
    public static void test1(){

        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("我是匿名内部类的游泳");
            }
        });
        goSwimming(()->{
            System.out.println("我是Lambda表达式的游泳");
        });
    }
    public static void goSwimming(Swimmable s){
        s.swimming();
    }

    /**
     * 2. 练习有参数有返回值的Lambda
     */
    public static void test2(){
        goSmoking(new Smokeable() {
            @Override
            public int smoking(String str) {
                System.out.println("抽了"+str+"的烟");
                return 5;
            }
        });

        goSmoking((String str)->{
            System.out.println("Lambada抽了"+str+"的烟");
            return 6;
        });
    }
    public static void goSmoking(Smokeable smokeable){
        int i = smokeable.smoking("中华");
        System.out.println("返回值："+i);
    }
}
