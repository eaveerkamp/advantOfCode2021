package com.eveerkamp.aoc.day10

import com.eveerkamp.aoc.utils.readFile

class Day10Part1 {
    private var input = readFile("day10/input.txt")
        .lines()
        .map { line -> line.windowed(1, 1) }

    private val tags = listOf(Pair("(", ")"), Pair("[", "]"), Pair("{", "}"), Pair("<", ">"))

    fun calculate(): Int {
        var illegalCount = 0
        input.forEach { line ->
            var stop = false
            val open = mutableListOf<String>()
            var closedCount = 0
            line.forEachIndexed { index, tag ->
                if (!stop) {
                    if (tag == "(" || tag == "[" || tag == "{" || tag == "<")
                        open.add(tag)
                    else {
                        if (open[index - closedCount - 1] == tags.firstOrNull { it.second == tag }?.first) {
                            open.removeAt(index - closedCount - 1)
                            closedCount += 2
                        } else {
                            stop = true
                            illegalCount += when (tag) {
                                ")" -> 3
                                "]" -> 57
                                "}" -> 1197
                                ">" -> 25137
                                else -> 0
                            }
                        }
                    }
                }
            }
        }
        return illegalCount
    }
}

