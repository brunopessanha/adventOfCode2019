package com.brunopessanha.adventOfCode2019.days

import com.brunopessanha.adventOfCode2019.AdventOfCode2019

private enum class OpCodes(val value: Int) {
    SUM(1) {
        override fun calculate(first: Int, second: Int): Int {
            return first + second
        }
    },
    MULTIPLICATION(2) {
        override fun calculate(first: Int, second: Int): Int {
            return first * second
        }
    },
    END(99) {
        override fun calculate(first: Int, second: Int): Int {
            return 0
        }
    };

    abstract fun calculate(first : Int, second : Int) : Int
}

class Day02 : AdventOfCode2019(2), Days<IntArray> {

    private var integers: IntArray = intArrayOf()
    private var sp = 0
    private val spStep = 4


    override fun read() = getInputAsString().split(',').map { it.toInt() }.toIntArray()

    private fun prepareInput() {
        integers = read()
        integers[1] = 12
        integers[2] = 2
    }

    private fun getArg1(): Int {
        return integers[integers[sp + 1]]
    }

    private fun getArg2(): Int {
        return integers[integers[sp + 2]]
    }

    private fun setOutput(value: Int) {
        integers[integers[sp + 3]] = value
    }

    fun computePartOne() : Int {
        prepareInput()
        while (sp < integers.size && integers[sp] != OpCodes.END.value) {
            when (integers[sp]) {
                OpCodes.SUM.value -> setOutput(OpCodes.SUM.calculate(getArg1(), getArg2()))
                OpCodes.MULTIPLICATION.value -> setOutput(OpCodes.MULTIPLICATION.calculate(getArg1(), getArg2()))
                OpCodes.END.value -> return integers[0]
            }
            sp += spStep
        }

        return integers[0]
    }


}

fun main() {
    println("The integer at position 0 is ${Day02().computePartOne()}")
}