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
            if (index >= windowSize) {
                val previousWindow = input.subList(index-windowSize, index).sum()
                val currentWindow = input.subList(index-windowSize+1, index+1).sum()
                if (currentWindow > previousWindow) increased++
            }
        }
        return increased
    }
}