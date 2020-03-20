package com.why.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflex5 {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("com.why.reflection.User");

            //通过newInstance构造对象
            User o = (User) c1.newInstance();
            o.setId(1);
            o.setAge(10);
            o.setName("why");
            System.out.println(o);

            //通过构造器创建对象
            Constructor<?> declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
            User why = (User) declaredConstructor.newInstance("why", 2, 20);
            System.out.println(why);

            //通过反射调用普通方法
            //1.获取一个方法
            Method setName = c1.getDeclaredMethod("setName", String.class);
            //2.invoke；激活的意思，设置方法的值
            setName.invoke(o,"AAA");
            System.out.println(o);

            Field age = c1.getDeclaredField("age");
            //关闭权限检测，强制赋值
            age.setAccessible(true);
            age.set(o,15);
            System.out.println(o);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
