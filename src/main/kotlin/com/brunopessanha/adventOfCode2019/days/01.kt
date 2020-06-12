package com.brunopessanha.adventOfCode2019.days

import com.brunopessanha.adventOfCode2019.AdventOfCode2019

class Day01 : AdventOfCode2019(1), Days<IntArray> {

    override fun read() = getInputAsString().split("\n").map { it.toInt() }.toIntArray()

    private fun calculateFuel(mass: Int) = kotlin.math.floor(mass.toDouble() / 3).toInt() - 2

    fun getFirstResult () = this.read().sumBy { calculateFuel(it) }

    fun getSecondResult (): Int {
        var total = 0
        this.read().forEach {
            var value = calculateFuel(it)
            while (value > 0) {
                total += value
                value = calculateFuel(value)
            }
        }
        return total
    }
}

fun main() {
    println("The result for part 1 is ${Day01().getFirstResult()}")
    println("The result for part 2 is ${Day01().getSecondResult()}")
}