package com.eveerkamp.aoc.day10

import com.eveerkamp.aoc.utils.readFile

class Day10Part2 {
    private var input = readFile("day10/input.txt")
        .lines()
        .map { line -> line.windowed(1, 1) }

    private val tags = listOf(Pair("(", ")"), Pair("[", "]"), Pair("{", "}"), Pair("<", ">"))

    fun calculate(): Long {
        val incompleteScores =
            input.mapNotNull { line ->
                val open = mutableListOf<String>()
                val corrupted = lineIsCorrupted(line, open)
                if (!corrupted) {
                    open.asReversed().map { tag ->
                        when (tags.firstOrNull { it.first == tag }?.second) {
                            ")" -> 1L
                            "]" -> 2L
                            "}" -> 3L
                            ">" -> 4L
                            else -> 0L
                        }
                    }.reduce { a, b -> (a * 5) + b }
                } else null
            }.sorted()
        return incompleteScores[(incompleteScores.size / 2)]
    }

    private fun lineIsCorrupted(
        line: List<String>,
        open: MutableList<String>
    ): Boolean {
        var isCorrupted = false
        var closedCount = 0
        line.forEachIndexed { index, tag ->
            if (!isCorrupted) {
                if (tag == "(" || tag == "[" || tag == "{" || tag == "<")
                    open.add(tag)
                else {
                    if (open[index - closedCount - 1] == tags.firstOrNull { it.second == tag }?.first) {
                        open.removeAt(index - closedCount - 1)
                        closedCount += 2
                    } else {
                        isCorrupted = true
                    }
                }
            }
        }
        return isCorrupted
    }
}
