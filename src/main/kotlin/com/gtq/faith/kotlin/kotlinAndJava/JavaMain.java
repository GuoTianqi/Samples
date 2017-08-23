package com.gtq.faith.kotlin.kotlinAndJava;

import com.gtq.faith.kotlin.Person;

public class JavaMain {
    public static void main(String args[]) {
        Person person = new Person("Tianqi", "Guo");
        System.out.println("Person Name = " + person.getLastName() + ", " +
                person.getFirstName() + " isOld = " + person.isOld());

        MyClass.Test.create();
        MyClass.create2();

        Key.COMPARATOR.compare(new Key(1), new Key(2));
        String s = Key.TEXT;
    }
}
