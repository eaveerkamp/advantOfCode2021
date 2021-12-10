package com.eveerkamp.aoc.day10

import com.eveerkamp.aoc.utils.readFile

class Day10Part2 {
    private var input = readFile("day10/input.txt")
        .lines()
        .map { line -> line.windowed(1, 1) }

    private val tags = listOf(Pair("(", ")"), Pair("[", "]"), Pair("{", "}"), Pair("<", ">"))

    fun calculate(): Long {
        val incompleteScores = mutableListOf<Long>()
        val open = mutableListOf<String>()
        input.forEach { line ->
            var stop = false
            open.clear()
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
                        }
                    }
                }
            }
            if (!stop) {
                var sum = 0L
                open.asReversed().forEach { tag ->
                    when (tags.firstOrNull { it.first == tag }?.second) {
                        ")" -> sum = ((sum * 5) + 1)
                        "]" -> sum = ((sum * 5) + 2)
                        "}" -> sum = ((sum * 5) + 3)
                        ">" -> sum = ((sum * 5) + 4)
                    }
                }
            }
        }
        incompleteScores.sort()
        return incompleteScores[(incompleteScores.size / 2)]
    }
}
