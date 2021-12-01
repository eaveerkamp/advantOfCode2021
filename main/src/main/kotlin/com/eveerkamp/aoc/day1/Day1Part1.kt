package com.eveerkamp.aoc.day1

import com.eveerkamp.aoc.utils.readFile

class Day1Part1 {
    private val input = readFile("day1/input.txt")
        .lines()
        .map { it.toInt() }

    fun calculate(): Int {
        var increased = 0
        input.forEachIndexed { index, number ->
            if (index > 0 && number > input[index - 1]) {
                increased++
            }
        }
        return increased
    }
}