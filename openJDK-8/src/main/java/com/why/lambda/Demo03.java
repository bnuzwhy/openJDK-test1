package com.why.lambda;

import java.util.*;

public class Demo03 {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("AAA",20,180));
        persons.add(new Person("BBB",30,190));
        persons.add(new Person("CCC",40,170));
        persons.add(new Person("DDD",50,160));

        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        Collections.sort(persons,(Person p1,Person p2)->{
            return p1.getAge()-p2.getAge();
        });

        for (Person person:persons) {
            System.out.println(person);
        }
    }
}
