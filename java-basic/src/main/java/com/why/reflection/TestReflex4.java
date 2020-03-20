package com.why.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflex4 {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("com.why.reflection.User");
            System.out.println(c1.getName());//获得包名+类名
            System.out.println(c1.getSimpleName());//获得类名

            System.out.println("=========类的属性==========");
            Field[] fields = c1.getFields();//只能找到public属性

            Field[] declaredFields = c1.getDeclaredFields();//能找到全部属性
            for(Field field : declaredFields){
                System.out.println(field);
            }

            System.out.println("=========获得指定属性的值=========");
            Field name = c1.getDeclaredField("name");
            System.out.println(name);

            System.out.println("==========获取类的方法==========");
            Method[] methods = c1.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            System.out.println("==========获取Declared类的方法==========");
            Method[] declaredMethods = c1.getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; i++) {
                System.out.println(declaredMethods[i]);
            }

            System.out.println("==========获取指定的方法==========");
            Method getName = c1.getMethod("getName", null);
            System.out.println(getName);
            Method setName = c1.getMethod("setName", String.class);
            System.out.println(setName);

            System.out.println("=========获取指定的构造器========");
            Constructor<?> constructor = c1.getConstructor();
            System.out.println(constructor);
            Constructor<?> constructor2 = c1.getConstructor(String.class, int.class, int.class);
            System.out.println(constructor2);
            System.out.println("=========获取构造器========");
            Constructor<?>[] constructors = c1.getConstructors();
            for (Constructor<?> constructor1 : constructors) {
                System.out.println(constructor1);
            }
            System.out.println("=========获取declared的构造器========");
            Constructor<?>[] declaredConstructors = c1.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
