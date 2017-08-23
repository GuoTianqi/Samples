package com.gtq.faith.kotlin.inlinefunc

inline fun <reified T> membersOf() = T::class.members

fun main(args: Array<String>) {
    println(membersOf<StringBuilder>().joinToString("\n"))
}