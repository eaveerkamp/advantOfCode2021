package com.eveerkamp.aoc.day5

import com.eveerkamp.aoc.utils.readFile
import kotlin.math.abs

val input = readFile("day5/input.txt")
    .lines()
    .map { line -> line.split(" -> ") }
    .map { line ->
        val begin = line.first().split(",").map { it.toInt() }
        val end = line.last().split(",").map { it.toInt() }
        val xLine = Pair(begin[0], end[0])
        val yLine = Pair(begin[1], end[1])
        Line(xLine, yLine)
    }

fun addPoint(
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

fun getPoints(a: Pair<Int, Int>, b: Pair<Int, Int>): List<Int> =
    when {
        a.first == a.second -> generateSequence { a.first }.take(abs(b.first - b.second) + 1).toList()
        a.first > a.second -> (a.first downTo a.second).toList()
        a.first < a.second -> (a.first until a.second + 1).toList()
        else -> emptyList()
    }