package com.gtq.faith.kotlin.cls

import com.gtq.faith.kotlin.cls.Base

class Derived: Base("Guo Tianqi") {
    override fun v() {
        println("Derived:v()")
    }

    fun nv1() {
        println("Derived:nv()")
    }
}