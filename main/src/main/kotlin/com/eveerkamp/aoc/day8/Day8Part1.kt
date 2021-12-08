package com.eveerkamp.aoc.day8

import com.eveerkamp.aoc.utils.readFile

class Day8Part1 {
    private var input = readFile("day8/input.txt")
        .lines()
        .map { it.split(" | ") }


    fun calculate(): Int {
        var count = 0
        input.forEach {
            it.last().split(" ").forEach { segment ->
                println(segment)
                when (segment.length) {
                    2, 3, 4, 7, 8 -> count++
                }
            }
        }
        return count
    }
}

