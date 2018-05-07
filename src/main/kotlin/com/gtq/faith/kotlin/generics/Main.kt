package com.gtq.faith.kotlin.generics

fun main(args: Array<String>) {
    val ints = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }

    copy(ints, any)
}

fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(to.size > from.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun fill(dest: Array<in String>, value: String) {
    dest.fill(value)
}