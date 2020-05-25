package com.gtq.faith.kotlin.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> { // start main coroutine
    launch { // launch a new coroutine in background and continue
        delay(200L)
        println("Task from runBlocking")
    }

//    launch { // launch a new coroutine in background and continue
//        delay(100L)
//        println("I am Crazy!!")
//    }
//
    coroutineScope {
        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope")
    }


    println("Coroutine scope is over")

}