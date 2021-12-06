package com.eveerkamp.aoc.day6

import com.eveerkamp.aoc.utils.readFile

class Day6Part2 {
    private var days = 256
    private var input = readFile("day6/input.txt")
        .lines()
        .first()
        .split(",")
        .map { it.toInt() }

    fun calculate(): Long {
        val fishByTime = input
            .groupBy { it }
            .mapValues { it.value.size.toLong() }
            .toMutableMap()

        repeat(days) {
            val newFish = fishByTime.getOrDefault(0, 0)
            (0..7).forEach { fishByTime[it] = fishByTime.getOrDefault(it + 1, 0) }
            fishByTime[6] = fishByTime.getOrDefault(6, 0) + newFish
            fishByTime[8] = newFish
        }
        return fishByTime.values.sum()
    }

}


