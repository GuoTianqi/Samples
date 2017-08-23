package com.gtq.faith.kotlin.reflection

var x = 1;

class A(val p: Int)

fun main(args: Array<String>) {
    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))

    val predicate: (String) -> Boolean = ::isOdd

    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))

    println(::x.get())

    println(strings.map(String::length))

    val prop = A::p
    println(prop.get(A(1)))

    val a = newClass(::A)
    println(a.p)
}

fun isOdd(x: Int) = x % 2 != 0
fun isOdd(s: String) = s == "brilling" || s == "slithy" || s == "tove"

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    // return {x -> f(g(x))}
    return fun(x: A) = f(g(x))
}

fun length(s: String) = s.length

fun newClass(factory: (x: Int) -> A): A {
    val x: A = factory(12)

    return x
}
