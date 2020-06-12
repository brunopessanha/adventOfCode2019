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

class Day02() : AdventOfCode2019(2), Days<IntArray> {

    private var instructions: IntArray = read()
    private var instructionPointer = 0
    private val instructionStep = 4

    override fun read() = getInputAsString().split(',').map { it.toInt() }.toIntArray()

    private fun prepareInput(noun: Int, verb: Int) {
        instructionPointer = 0
        instructions = read()
        instructions[1] = noun
        instructions[2] = verb
    }

    private fun getArg1(): Int {
        return instructions[instructions[instructionPointer + 1]]
    }

    private fun getArg2(): Int {
        return instructions[instructions[instructionPointer + 2]]
    }

    private fun setOutput(value: Int) {
        instructions[instructions[instructionPointer + 3]] = value
    }

    private fun getOutput() : Int {
        return instructions[0]
    }

    private fun computationNotFinished() = instructionPointer < instructions.size
            && instructions[instructionPointer] != OpCodes.END.value

    private fun fetchNextInstruction() {
        instructionPointer += instructionStep
    }

    fun compute(noun: Int,  verb: Int) : Int {
        prepareInput(noun, verb)
        while (computationNotFinished()) {
            when (instructions[instructionPointer]) {
                OpCodes.SUM.value -> setOutput(OpCodes.SUM.calculate(getArg1(), getArg2()))
                OpCodes.MULTIPLICATION.value -> setOutput(OpCodes.MULTIPLICATION.calculate(getArg1(), getArg2()))
                OpCodes.END.value -> return getOutput()
            }
            fetchNextInstruction()
        }
        return getOutput()
    }

}

fun main() {

    val day02 = Day02()
    var currentResult = day02.compute(12, 2)

    println("Part 1 - The integer at position 0 is $currentResult")

    val expectedResult = 19690720
    for(noun in 0..100) {
        for (verb in 0..100) {
            currentResult = day02.compute(noun, verb)
            if (currentResult == expectedResult) {
                println("Part 2 - 100 * noun + verb = ${(100 * noun) + verb}")
                return
            }
        }
    }
}