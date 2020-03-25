package com.gtq.faith.kotlin.kotlinAndJava

/**
 * Created by guotianqi on 2017/8/27.
 */
object KotlinSingleton {
    @JvmField
    var prop: String
    init {
        prop = "Hello world"
    }

    @JvmStatic
    fun doSomethins() {

    }
}