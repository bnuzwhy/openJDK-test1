package com.why.reflect;

import com.why.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        //1.获取Person的Class对象
        Class<Person> personClass = Person.class;
        //2.获取构造方法
        Constructor<Person> constructor = personClass.getConstructor(String.class, Integer.class);
        Person person = constructor.newInstance("张三",23);
        System.out.println(person);

        Constructor<Person> constructor1 = personClass.getConstructor();
        Person person1 = constructor1.newInstance();
        System.out.println(person1);

        Person person2 = personClass.newInstance();
        System.out.println(person2);
    }
}
