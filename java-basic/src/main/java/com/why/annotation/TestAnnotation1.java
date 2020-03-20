package com.why.annotation;

import java.lang.annotation.*;

/**
 * 测试元注解
 * @Target 设置在哪个位置有效
 * @Retention 表示注解在什么地方还有效（默认runtime） runtime > class > sources
 * @Documented //表示是否将我们的注解生成在javadoc中
 * @Inherited //表示子类可以继承父类的注解
 */
public class TestAnnotation1 {
    @MyAnnotation
    public void test(){

    }
}


@Target(value = ElementType.METHOD) //方法有效
@Retention(value = RetentionPolicy.RUNTIME) //
@Documented //表示是否将我们的注解生成在javadoc中
@Inherited //表示子类可以继承父类的注解
@interface MyAnnotation{

}