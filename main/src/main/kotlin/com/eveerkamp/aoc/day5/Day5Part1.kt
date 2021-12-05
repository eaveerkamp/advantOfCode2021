package com.eveerkamp.aoc.day5

import com.eveerkamp.aoc.utils.readFile

class Day5Part1 {
    private val input = readFile("day5/input.txt")
        .lines()
        .map { line -> line.split(" -> ") }
        .map {  line ->
            val begin = line.first().split(",").map { it.toInt() }
            val end = line.last().split(",").map { it.toInt() }
            val xLine = if (begin[0] >= end[0]) Pair(end[0], begin[0]) else Pair(begin[0], end[0])
            val yLine = if (begin[1] >= end[1]) Pair(end[1], begin[1]) else Pair(begin[1], end[1])
            Line(xLine, yLine)
        }

    fun calculate(): Int {
        val diagram: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
        input.forEach { line ->
            if (line.horizontalOrVerticalLine) {
                for (x in line.x.first until line.x.second + 1) {
                    for (y in line.y.first until line.y.second + 1) {
                        if (diagram[Pair(x, y)] != null) {
                            diagram[Pair(x, y)] = diagram[Pair(x, y)]!! + 1
                        } else {
                            diagram[Pair(x, y)] = 1
                        }
                    }
                }
            }
        }
        return diagram.count { it.value > 1 }
    }
}

