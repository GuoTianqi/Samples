package com.gtq.faith.java;

import com.gtq.faith.kotlin.Person;
import com.gtq.faith.kotlin.kotlinAndJava.Key;
import com.gtq.faith.kotlin.kotlinAndJava.KotlinSingleton;
import com.gtq.faith.kotlin.kotlinAndJava.MyClass;

public class JavaMain {
    public static void main(String args[]) {
        Person person = new Person("Tianqi", "Guo");
        System.out.println("Person Name = " + person.getLastName() + ", " +
                person.getFirstName() + " isOld = " + person.isOld());

        MyClass.Test.create();
        MyClass.create2();

        Key.COMPARATOR.compare(new Key(1), new Key(2));
        String s = Key.TEXT;

        KotlinSingleton.doSomethins();

        System.out.println("JAVA ============");
    }
}
