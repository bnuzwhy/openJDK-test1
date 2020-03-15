package com.why.reflect;

import com.why.domain.Person;

import java.lang.reflect.Field;

/**
 * 获取Class对象的方式有哪些？
 *
 * ​	    1.Class.forName("全类名")：将字节码文件加载进内存，返回class对象
 *
 * ​		2.类名.class：通过类名的属性class获取
 *
 * ​		3.对象.getClass()：getClass()方法在Object类中定义着
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //1.Class.forName("全类名")
        Class person1 = Class.forName("com.why.domain.Person");
        System.out.println(person1);

        //2.类名.class：通过类名的属性class获取
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //3.对象.getClass()：getClass()方法在Object类中定义着
        Person p = new Person();
        Class aClass = p.getClass();
        System.out.println(aClass);

        System.out.println(person1 == personClass);
        System.out.println(aClass == personClass);
    }
}
