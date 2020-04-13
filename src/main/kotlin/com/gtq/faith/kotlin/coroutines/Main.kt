package com.gtq.faith.kotlin.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> { // start main coroutine
    launch { // launch a new coroutine in background and continue
        delay(1000L)
        println("World!")
    }
    println("Hello,") // main coroutine continues here immediately
}