package com.gtq.faith.kotlin.delegation

fun main(args: Array<String>) {
    val b = BaseImpl(10)
    val d = Derived(b)
    d.printA()
    d.printB()
}