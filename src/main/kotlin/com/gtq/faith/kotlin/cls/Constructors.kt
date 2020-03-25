package com.gtq.faith.kotlin.cls

/**
 * 请注意，初始化块中的代码实际上会成为主构造函数的一部分。委托给主构造函数会作为次构造函数的第一条语句，
 * 因此所有初始化块中的代码都会在次构造函数体之前执行。即使该类没有主构造函数，这种委托仍会隐式发生，
 * 并且仍会执行初始化块：
 */
class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Constructors(1)
        }
    }
}