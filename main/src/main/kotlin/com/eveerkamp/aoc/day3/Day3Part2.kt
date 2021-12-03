package com.eveerkamp.aoc.day3

import com.eveerkamp.aoc.utils.readFile
import java.lang.Integer.parseInt

class Day3Part2 {
    private val input = readFile("day3/input.txt")
        .lines()

    fun calculate(): Int {
        val oxygen = filterTest { bits -> if (bits.count { it == 1 } >= bits.count { it == 0 }) "1" else "0" }
        val co2 = filterTest { bits -> if (bits.count { it == 1 } >= bits.count { it == 0 }) "0" else "1" }
        return oxygen * co2
    }

    private fun filterTest(filter: (bits: List<Int>) -> String): Int {
        var filteredInput = input
        while (filteredInput.size > 1) {
            for (position in 0..filteredInput.maxOf { it.length }) {
                if (filteredInput.size > 1) {
                    val bits = getBitsByPosition(filteredInput, position)
                    filteredInput = filteredInput.filter { line -> line[position].toString() == filter.invoke(bits) }
                }
            }
        }
        return parseInt(filteredInput.first(), 2)
    }

    private fun getBitsByPosition(input: List<String>, position: Int): MutableList<Int> {
        val bitsByPosition: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        input.map { bit ->
            bit.forEachIndexed { position, char ->
                bitsByPosition[position]?.add(char.digitToInt()) ?: bitsByPosition.put(
                    position,
                    mutableListOf(char.digitToInt())
                )
            }
        }
        return bitsByPosition[position] ?: mutableListOf()
    }
}
