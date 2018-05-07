package com.gtq.faith.kotlin.DelegatedProperties

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val example = Example()
    println(example.p)
    example.p = "OOOPPPPPPPPPP-====="
    println(example.p)

    println(example.lazyValue)
    println(example.lazyValue)

    val sum: (Int, Int) -> Int = { x, y -> x + y }
}

class Example {
    var p: String by MyDelegate()
    val lazyValue: String by lazy {
        println("computed")
        "Hello"
    }

    class MyDelegate: ReadWriteProperty<Example, String> {
        override fun getValue(thisRef: Example, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        override fun setValue(thisRef: Example, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name} in $thisRef.'")
            //thisRef.p = value
        }

    }
}
