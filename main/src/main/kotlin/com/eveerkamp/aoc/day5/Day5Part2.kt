package com.eveerkamp.aoc.day5

class Day5Part2 {
    fun calculate(): Int {
        val diagram: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
        input.forEach { line ->
            val xPoints = getPoints(line.x, line.y)
            val yPoints = getPoints(line.y, line.x)
            xPoints.forEachIndexed { index, x -> addPoint(diagram, x, yPoints[index]) }
        }
        return diagram.count { it.value > 1 }
    }
}

