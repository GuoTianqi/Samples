package com.gtq.faith.kotlin.algorithm.codinginterview.ch01.arrays_and_strings.q1_01_is_unigue

fun main() {
    val words = arrayOf("abcde", "hello", "apple", "kite", "padle")
    words.forEach {
        println("$it : ${charSame(it)})")
        println("$it : ${charSame2(it)})")
    }
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

// 假设只有26的英文字母
private fun charSame2(str: String): Boolean {
    if (str.length > 26) {
        return false
    }

    var checker = 0
    str.forEach {
        val value = it - 'a'
        if ((checker and (1 shl value)) > 0) {
            return false
        }
    }

    return true
}