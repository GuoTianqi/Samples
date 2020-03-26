package com.gtq.faith.kotlin.algorithm.codinginterview.ch01.arrays_and_strings.q1_02_check_permutation

fun main() {
    val words1 = {"abcdefg"}
    val words2 = {"gabcdef"}
    val paris = arrayOf(
        arrayOf("abcdefg", "gabcdef")
    )

    paris.forEach {
        println("${it[0]}, ${it[1]}: ${check(it[0], it[1])}")
    }
}

fun check(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) {
        return false
    }

    val charNumArr = IntArray(128)
    for (i in s1.indices) {
        charNumArr[s1[i].toInt()]++
    }
    for (i in s2.indices) {
        if (--charNumArr[s2[i].toInt()] < 0) {
            return false
        }
    }

    return true;
}
