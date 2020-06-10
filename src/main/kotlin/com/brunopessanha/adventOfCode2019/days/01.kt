package com.brunopessanha.adventOfCode2019.days

import com.brunopessanha.adventOfCode2019.AdventOfCode2019

class Day01 : AdventOfCode2019(1), Days<IntArray> {

    override fun read() = getInputAsString().split("\n").map { it.toInt() }.toIntArray()

    fun getResult () = this.read().sumBy { kotlin.math.floor(it.toDouble() / 3).toInt() - 2 }
}

fun main() {
    println("The result is ${Day01().getResult()}")
}