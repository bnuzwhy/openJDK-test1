package com.why.reflect;

import com.why.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        //1.获取Person的Class对象
        Class<Person> personClass = Person.class;

        Person person = personClass.newInstance();
        //2.获取成员方法
        Method eat = personClass.getMethod("eat");
        eat.invoke(person);

        Method method = personClass.getMethod("eat", String.class);
        method.invoke(person,"fan");


    }
}
