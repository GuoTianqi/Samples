package com.gtq.faith.kotlin

/**
 * Created by guotianqi on 2017/6/7.
 */
class Person(val firstName: String, val lastName: String) {
    var age: Int = 0

    val isOld = this.age > 60

    val hasClild: Boolean
        get() {
            return children.isEmpty()
        }

    private var _children: MutableList<Person>? = null

    val children: MutableList<Person>
        get() {
            if (_children == null) {
                _children = mutableListOf()
            }

            return _children ?: throw AssertionError("")
        }

    constructor(firstName: String, lastName: String, age: Int) : this(firstName, lastName) {
        this.age = age
    }

    fun addChild(person: Person) {
        children.add(person)
    }

    override fun toString(): String {
        return "firstName=${firstName}\n" +
                "lastName=${lastName}\n" +
                "age=${age}\n" +
                "isOld=${isOld}\n";
    }
}