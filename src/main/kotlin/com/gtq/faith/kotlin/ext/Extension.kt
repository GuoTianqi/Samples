package com.gtq.faith.kotlin.ext

/**
 * Created by guotianqi on 2017/6/25.
 */

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp;
}

fun Any?.toString(): String {
    if (this == null) return "nullObject"
    return toString()
}