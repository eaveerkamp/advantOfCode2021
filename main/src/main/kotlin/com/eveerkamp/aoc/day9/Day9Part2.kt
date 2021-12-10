package com.eveerkamp.aoc.day9

import com.eveerkamp.aoc.utils.readFile

class Day9Part2 {
    private var input = readFile("day9/input.txt")
        .lines()
        .mapIndexed { index, line -> index to line.toCharArray().toList().map { it.digitToInt() } }.toMap()

    private val usedPoints = mutableListOf<Pair<Int, Int>>()
    private var count = 0

    fun calculate(): Int {
        val basins = mutableListOf<Int>()

        input.forEach { (index, line) ->
            line.forEachIndexed { indexInLine, nr ->
                val up = if (index > 0) input[index - 1]!![indexInLine] else 9
                val down = if (index < input.size - 1) input[index + 1]!![indexInLine] else 9
                val left = if (indexInLine > 0) input[index]!![indexInLine - 1] else 9
                val right = if (indexInLine < line.size - 1) input[index]!![indexInLine + 1] else 9
                if (up > nr && down > nr && left > nr && right > nr) {
                    count = 0
                    calculateBasin(index, indexInLine)
                    basins.add(count)
                }
            }
        }
        println(basins.sortedDescending().subList(0, 3))
        return basins.sortedDescending().subList(0, 3).reduce { a, b -> a * b }
    }

    private fun calculateBasin(index: Int, indexInLine: Int) {
        if (!usedPoints.contains(Pair(index, indexInLine))) {
            usedPoints.add(Pair(index, indexInLine))
            var start = input[index]!![indexInLine]
            println("$index, $indexInLine -> $start")
            count++
            while (start < 9) {
                for (i in 0 until 5) {
                    when (i) {
                        0 -> {
                            val next = if (index > 0) input[index - 1]!![indexInLine] else 9 //go up
                            if (next in (start + 1)..8) {
                                calculateBasin(index - 1, indexInLine)
                            }
                        }
                        1 -> {
                            val next = if (index < input.size - 1) input[index + 1]!![indexInLine] else 9
                            if (next in (start + 1)..8) {
                                calculateBasin(index + 1, indexInLine)
                            }
                        } //go down
                        2 -> {
                            val next = if (indexInLine > 0) input[index]!![indexInLine - 1] else 9
                            if (next in (start + 1)..8) {
                                calculateBasin(index, indexInLine - 1)
                            }
                        } //go left
                        3 -> {
                            val next =
                                if (indexInLine > 0 && indexInLine < input[index]!!.size - 1) input[index]!![indexInLine + 1] else 9
                            if (next in (start + 1)..8) {
                                calculateBasin(index, indexInLine + 1)
                            }
                        } //go right
                        else -> start = 9
                    }
                }
            }
        }
    }
}
