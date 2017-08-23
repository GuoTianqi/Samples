package com.gtq.faith.kotlin.kotlinAndJava

class Key(val value: Int) {
    companion object Utils {
        const val TEXT: String = "Hello World!"

        @JvmField
        val COMPARATOR: Comparator<Key> = compareBy<Key> { it.value }
    }
}