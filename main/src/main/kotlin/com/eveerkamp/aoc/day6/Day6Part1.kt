package com.eveerkamp.aoc.day6

import com.eveerkamp.aoc.utils.readFile

class Day6Part1 {
    private var input = readFile("day6/input.txt")
        .lines()
        .first()
        .split(",")
        .map { it.toInt() }
        .toMutableList()


    private var numberOfDays = 80

    fun calculate(): Int {
        for (day in 0 until numberOfDays) {
            val newList = mutableListOf<Int>()
            var newFishCount = 0
            input.forEach { fish ->
                if (fish == 0) {
                    newList.add(6)
                    newFishCount++
                } else {
                    newList.add(fish - 1)
                }
            }
            newList.addAll(generateSequence { 8 }.take(newFishCount).toList())
            input = newList
        }
        return input.size
    }
}

