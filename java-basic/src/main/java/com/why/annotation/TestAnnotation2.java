package com.why.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
public class TestAnnotation2 {
    //注解可以显示赋值，如果没有默认值，我们就必须给注解默认值
    @MyAnnotation2(name = "abc",schools = {"北京大学","清华大学"})
    public void test(){

    }

    @MyAnnotation3("abc")
    public void test2(){

    }
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：参数类型+参数名（）；
    String name() default "";
    int age() default 0;
    int id() default -1;//如果默认值为-1，代表不存在

    String[] schools();
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    //只有一个值，且名为value；使用时value可以省略
    String value();
}
