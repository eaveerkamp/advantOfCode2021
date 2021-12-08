package com.eveerkamp.aoc.day8

import com.eveerkamp.aoc.utils.readFile

class Day8Part2 {
    private var input = readFile("day8/input.txt")
        .lines()
        .map { it.split(" | ") }

    fun calculate(): Int {
        return input.sumOf {
            val input = it.first().sanitize()
            val map = mapInput(input.sortedBy { segment -> segment.length })
            it.last().sanitize()
                .map { map.filterValues { segments -> segments == it }.keys.first() }
                .joinToString("")
                .toInt()
        }
    }

    private fun mapInput(input: List<String>): MutableMap<Int, String> {
        val map = mutableMapOf<Int, String>()
        for (i in 0 until 10) {
            map[i] = ""
        }
        input.forEach { segment ->
            when (segment.length) {
                2 -> map[1] = segment
                4 -> map[4] = segment
                3 -> map[7] = segment
                7 -> map[8] = segment
                5 -> when {
                    map[1]!!.toList().intersect(segment.toList().toSet()).size == 2 -> map[3] = segment
                    map[4]!!.toList().intersect(segment.toList().toSet()).size == 3 -> map[5] = segment
                    else -> map[2] = segment
                }
                6 -> when {
                    map[1]!!.toList().intersect(segment.toList().toSet()).size < 2 -> map[6] = segment
                    map[4]!!.toList().intersect(segment.toList().toSet()).size == 4 -> map[9] = segment
                    else -> map[0] = segment
                }
            }
            map.toSortedMap().values.toString()
        }
        return map
    }


}

private fun String.sanitize(): List<String> =
    this.split(" ").map { signal -> signal.toList().sorted().joinToString("") }


