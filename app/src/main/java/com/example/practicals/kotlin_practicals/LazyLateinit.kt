package com.example.practicals.kotlin_practicals

class LazyLateinit {

    lateinit var name: String
    val name1: String by lazy {
        "bansi"
    }

    fun isInit() {
        if (this::name.isInitialized)
            println("not initialized");
        else {
            name = "mansi"
            println(this.name)
        }
    }
}

fun main() {
    var s1=LazyLateinit()
    s1.isInit()
    print(s1.name1)
}