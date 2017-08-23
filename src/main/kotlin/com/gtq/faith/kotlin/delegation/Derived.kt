package com.gtq.faith.kotlin.delegation

class Derived(val b: Base): Base by b {
    override fun printB() {
        println("Derived:")
        b.printB()
    }
}