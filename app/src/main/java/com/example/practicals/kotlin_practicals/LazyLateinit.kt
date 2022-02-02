package com.example.practicals.kotlin_practicals

class LazyLateinit {
    lateinit var nameF: String
    val nameT: String by lazy {
        "bansi"
    }

    fun isInit() {
        if (this::nameF.isInitialized)
            println("not initialized");
        else {
            nameF = "mansi"
            println(this.nameF)
        }
    }
}

fun main() {
    var lazyinit = LazyLateinit()
    lazyinit.isInit()
    print(lazyinit.nameT)
}