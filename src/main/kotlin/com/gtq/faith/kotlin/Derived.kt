package com.gtq.faith.kotlin

class Derived: Base() {
    override fun v() {
        println("Derived:v()")
    }

    fun nv1() {
        println("Derived:nv()")
    }
}