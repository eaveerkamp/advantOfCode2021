package com.eveerkamp.aoc.day7

import com.eveerkamp.aoc.utils.readFile
import kotlin.math.abs

class Day7Part2 {
    private var input = readFile("day7/input.txt")
        .lines()
        .first()
        .split(",")
        .map { it.toInt() }
        .toMutableList()

    fun calculate(): Int {
        input.sort()
        val median = if (input.size % 2 == 0) {
            (input[input.size / 2] + input[(input.size / 2) - 1]) / 2
        } else
            input[input.size / 2]
        return input.sumOf { ((abs(it - median) * (abs(it-median)+1)) / 2) }
    }

}


