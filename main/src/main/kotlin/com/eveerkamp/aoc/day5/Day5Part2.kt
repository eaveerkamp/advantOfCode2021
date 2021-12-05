package com.eveerkamp.aoc.day5

import com.eveerkamp.aoc.utils.readFile
import kotlin.math.abs

class Day5Part2 {
    private val input = readFile("day5/input.txt")
        .lines()
        .map { line -> line.split(" -> ") }
        .map { line ->
            val begin = line.first().split(",").map { it.toInt() }
            val end = line.last().split(",").map { it.toInt() }
            val xLine = Pair(begin[0], end[0])
            val yLine = Pair(begin[1], end[1])
            Line(xLine, yLine)
        }

    fun calculate(): Int {
        val diagram: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
        input.forEach { line ->
            val allX = getAllFromLine(line.x, line.y)
            val allY = getAllFromLine(line.y, line.x)
            allX.forEachIndexed {index, x -> addToDiagram(diagram, x, allY[index])  }
        }
        return diagram.count { it.value > 1 }
    }

    private fun getAllFromLine(a: Pair<Int, Int>, b: Pair<Int, Int>): List<Int> {
        val all = when {
            a.first == a.second -> {
                val list = mutableListOf<Int>()
                for (i in 0..abs(b.first - b.second)) {
                    list.add(a.first)
                }
                list.toList()
            }
            a.first > a.second -> (a.first downTo a.second).toList()
            a.first < a.second -> (a.first until a.second + 1).toList()
            else -> emptyList()
        }
        return all
    }

    private fun addToDiagram(
        diagram: MutableMap<Pair<Int, Int>, Int>,
        x: Int,
        y: Int
    ) {
        if (diagram[Pair(x, y)] != null) {
            diagram[Pair(x, y)] = diagram[Pair(x, y)]!! + 1
        } else {
            diagram[Pair(x, y)] = 1
        }
    }

}

