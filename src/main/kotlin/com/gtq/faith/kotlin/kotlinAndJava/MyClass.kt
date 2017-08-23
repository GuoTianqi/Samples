package com.gtq.faith.kotlin.kotlinAndJava

class MyClass {
    companion object Test {
        fun create(): MyClass = MyClass()
        @JvmStatic
        fun create2(): MyClass = MyClass()
    }
}