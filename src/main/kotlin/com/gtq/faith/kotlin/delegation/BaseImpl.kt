package com.gtq.faith.kotlin.delegation

class BaseImpl(val x: Int): Base {
    override fun printA() {
        println("A: $x")
    }

    override fun printB() {
        println("B: $x")
    }
}