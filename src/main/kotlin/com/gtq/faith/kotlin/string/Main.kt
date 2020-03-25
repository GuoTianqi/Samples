package com.gtq.faith.kotlin.string

fun main(args: Array<String>) {
    println("""
            Foo
               Bar""".trimIndent())

    val a = """if(a > 1) {
          |    return a
          |}""".trimMargin()

    println(a)

    Any().let {  }
    Any().apply {  }
}

