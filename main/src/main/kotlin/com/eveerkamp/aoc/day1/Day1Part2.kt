package com.eveerkamp.aoc.day1

import com.eveerkamp.aoc.utils.readFile

class Day1Part2 {
    private val windowSize = 3
    private val input = readFile("day1/input.txt")
        .lines()
        .map { it.toInt() }

    fun calculate(): Int {
        var increased = 0
        input.forEachIndexed { index, _ ->
            if (index > 2) {
                var currentWindow = 0
                var previousWindow = 0
                for (current in windowSize-1 downTo 0)
                    currentWindow += input[index - current]
                for (previous in windowSize downTo 1)
                    previousWindow += input[index - previous]

                if (currentWindow > previousWindow) increased++
            }
        }
        return increased
    }
}