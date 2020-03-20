package com.why.reflection;

/**
 * 反射reflection
 *
 * 反射和注解配合，天衣无缝
 */
public class TestReflex2 {
    public static void main(String[] args) {
        Person person = new Student();
        System.out.println("这个人是："+person.name);

        //方式一：通过兑现获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二：通过forName获得
        try {
            Class c2 = Class.forName("com.why.reflection.Student");
            System.out.println(c2.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //方式三：通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四：基本内置类型的包装类都有一个type属性，比较特殊，只有内置包装类可以用
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);

        //获取父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
        System.out.println(c5.hashCode());

    }

}

class Person{
    String name;

    public Person(){}
    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}