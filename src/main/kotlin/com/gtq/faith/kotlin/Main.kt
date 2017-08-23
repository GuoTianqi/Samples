package com.gtq.faith.kotlin

import com.gtq.faith.kotlin.ext.toString

/**
 * Created by guotianqi on 2017/6/6.
 */
fun main(args: Array<String>) {
    println("Hello World!");

    val a: Int? = 10000;
    val b: Long? = a?.toLong();
    // error
    // println(a === b);

    val l = 1L + 3
    println(l);
    // val x = 1.shl(2).and(0x000FF000);
    val x = (1 shl 2) and 0x000FF000;

    println(x);

    val person = Person("Tianqi", "Guo", 31);
    println(
            "persion firstName=${person.firstName}, lastName=${person.lastName}, " +
                    "age=${person.age}, isOld=${person.isOld}, children = "
    )

    val child = Person("XXXX", "Guo", 1)
    person.addChild(child)

    for (child in person.childend) {
        println("---------")
        println(child.toString())
    }

    var nullObject: Int? = null
    println(nullObject.toString())

    println("nanoTime = ${System.nanoTime()}")
}

abstract class Source<out T> {
    abstract fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // This is OK, since T is an out-parameter
    // ...
}

