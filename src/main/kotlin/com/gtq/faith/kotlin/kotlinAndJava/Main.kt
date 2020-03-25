package com.gtq.faith.kotlin.kotlinAndJava

import com.gtq.faith.java.JavaArrayExample
import java.util.*
import java.util.concurrent.Executors

fun main(args: Array<String>) {
    val list = ArrayList<String>() // non-null (constructor result)
    list.add("Item")
    val size = list.size // non-null (primitive int)
    val item = list[0] // platform type inferred (ordinary Java object)
    val nullableStr: String? = item
    val notNullStr: String = item

    val javaObj = JavaArrayExample()
    val array = intArrayOf(0, 1, 2, 3)
    javaObj.removeIndices(array)

    val array2 = intArrayOf(1, 2, 3, 4)
    javaObj.removeIndices2(*array2)

    val mutableList = mutableListOf<String>()

    // val runnable = Runnable { println("this runs in a runnable"); look.notify() }
    val executor = Executors.newSingleThreadExecutor()
    executor.execute {
        println("this runs in a runnable")
        System.out.flush()
    }

    val person = Person("Tianqi", "Guo")
    println("Person Name = ${person.lastName} ${person.firstName}")
}