package com.eveerkamp.aoc.day2

import com.eveerkamp.aoc.utils.readFile

class Day2Part1 {
    private val input = readFile("day2/input.txt")
        .lines()
        .map {
            val line = it.split(" ")
            Pair(line[0], line[1].toInt())
        }

    fun calculate(): Int {
        var horizontal = 0
        var dept = 0
        input.forEach { (commando, input) ->
            when (commando) {
                "forward" -> horizontal += input
                "down" -> dept += input
                "up" -> dept -= input
            }
        }
        return horizontal * dept
    }
}