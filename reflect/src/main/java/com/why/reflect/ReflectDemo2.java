package com.why.reflect;

import com.why.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        //1.获取Person的Class对象
        Class<Person> personClass = Person.class;
        //2.获取成员变量
        Field[] fields = personClass.getFields();
        for(Field field : fields){
            System.out.println(field);
        }
        Person p = new Person();
        Field a = personClass.getField("a");
        a.set(p,"zhangsan");

        Object o = a.get(p);
        System.out.println(o);
        System.out.println("=================");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object o1 = d.get(p);
        System.out.println(o1);
    }
}
