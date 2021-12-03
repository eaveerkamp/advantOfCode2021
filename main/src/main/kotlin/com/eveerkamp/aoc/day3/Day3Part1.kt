package com.eveerkamp.aoc.day3

import com.eveerkamp.aoc.utils.readFile
import java.lang.Integer.parseInt

class Day3Part1 {
    private val input = readFile("day3/input.txt")
        .lines()

    fun calculate(): Int {
        val bitsByPosition: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        input.map { bit ->
            bit.forEachIndexed { position, char ->
                bitsByPosition[position]?.add(char.digitToInt()) ?: bitsByPosition.put(
                    position,
                    mutableListOf(char.digitToInt())
                )
            }
        }

        val gammaBits: MutableList<String> = mutableListOf()
        val epsilonsBits: MutableList<String> = mutableListOf()

        bitsByPosition.toSortedMap().forEach { (_, bits) ->
            if (bits.count { it == 1 } > bits.count { it == 0 }) {
                gammaBits.add("1")
                epsilonsBits.add("0")
            } else if (bits.count { it == 0 } > bits.count { it == 1 }) {
                gammaBits.add("0")
                epsilonsBits.add("1")
            }
        }

        val gamma = parseInt(gammaBits.joinToString(""), 2)
        val epsilon = parseInt(epsilonsBits.joinToString(""), 2)
        return gamma * epsilon
    }
}
