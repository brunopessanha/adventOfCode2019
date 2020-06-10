package com.brunopessanha.adventOfCode2019

import java.io.File

open class AdventOfCode2019 (day: Int) {

    private val fileName = "src/main/resources/inputs/$day.txt"

    protected fun getInputAsString() : String {
        return File(fileName).readText()
//        return this.javaClass::class.java.getResource(fileName).readText()
    }
}