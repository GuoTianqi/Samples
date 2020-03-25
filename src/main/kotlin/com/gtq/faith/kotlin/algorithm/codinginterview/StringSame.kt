package com.gtq.faith.kotlin.algorithm.codinginterview

fun main() {
    val s1 = "Hello World"
    charSame(s1)
}

private fun charSame(s: String): Boolean {
    val set = hashSetOf<Char>()
    s.forEach {
        if (set.contains(it)) {
            println("$s char not same")
            return false
        }
    }
    println("$s char is same")
    return true
}