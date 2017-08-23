package com.gtq.faith.kotlin.collection

import com.gtq.faith.kotlin.inlinefunc.membersOf
import java.io.IOException

fun main(args: Array<String>) {
    val numbers = mutableListOf(1, 2, 3)
    val readOnlyView: List<Int> = numbers
    println(numbers)
    numbers.add(4)
    println(readOnlyView)

    val strings = hashSetOf("a", "b", "c", "c")
    strings.add("d")
    assert(strings.size == 3)

    val test: (String) -> Boolean = fun(s: String) : Boolean {
        s.length
        return true
    }
}
