package com.gtq.faith.kotlin

/**
 * Created by guotianqi on 2017/6/7.
 */
class Person(val firstName: String, val lastName: String) {
    var age: Int = 0

    val isOld = this.age > 60

    private var _childend: MutableList<Person>? = null

    val childend: MutableList<Person>
        get() {
            if (_childend == null) {
                _childend = mutableListOf()
            }

            return _childend ?: throw AssertionError("")
        }

    constructor(firstName: String, lastName: String, age: Int) : this(firstName, lastName) {
        this.age = age
    }

    fun addChild(person: Person) {
        childend.add(person)
    }

    override fun toString(): String {
        return "firstName=${firstName}\n" +
                "lastName=${lastName}\n" +
                "age=${age}\n" +
                "isOld=${isOld}\n";
    }
}