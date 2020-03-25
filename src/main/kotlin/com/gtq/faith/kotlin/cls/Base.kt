package com.gtq.faith.kotlin.cls

open class Base(name: String, age: Int = 18) {
    val name = name
    val age: Int
    var email: String? = null

    init {
        this.age = age
    }

    constructor(name: String, age: Int, email: String) : this(name, age){
        this.email = email
    }

    open fun v() {
        println("Base:v()")
    }

    fun nv() {
        println("Base:nv()")
    }
}