package com.brunopessanha.adventOfCode2019

import assertk.assertThat
import com.brunopessanha.adventOfCode2019.days.Day01
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AdventOfCode2019Test {

    @Test
    fun checkWhetherAllInputsWereParsedCorrectlyFromDay01Test() {
        val day01 = Day01()
        val result = day01.read()
        assertThat { result.size == 100 }
        assertThat { day01.getFirstResult() ==  3279287}
    }
}