package com.gtq.faith.kotlin.enum

fun main(args: Array<String>) {
    printAllValues<RGB>()
}

enum class RGB {
    RED, GREEN, BLUE
}

inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}