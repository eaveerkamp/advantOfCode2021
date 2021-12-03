package com.eveerkamp.aoc.day3

import com.eveerkamp.aoc.utils.readFile
import java.lang.Integer.parseInt

class Day3Part2 {
    private val input = readFile("day3/input.txt")
        .lines()

    fun calculate(): Int {
       return getOutput(input, ::filterCO2Scrubber) * getOutput(input, ::filterOxygenGenerator)
    }

    private fun getOutput(input: List<String>, filter: (input: List<String>, position: Int) -> List<String>) : Int {
        var copyInput = input
        while (copyInput.size > 1) {
            for(position in 0..copyInput.maxOf { it.length }){
                if (copyInput.size > 1) {
                    copyInput = filter(copyInput, position)
                }
            }
        }
        return parseInt(copyInput.first(), 2)
    }

    private fun filterOxygenGenerator(
        input: List<String>,
        position: Int
    ): List<String> {
        var oxygenInput = input
        val bits = getBitsByPosition(oxygenInput)[position] ?: listOf()
        oxygenInput = if (bits.count { it == 1 } >= bits.count { it == 0 }) {
            oxygenInput.filter { it[position].toString() == "1" }
        } else {
            oxygenInput.filter { it[position].toString() == "0" }
        }
        return oxygenInput
    }

    private fun filterCO2Scrubber(
        input: List<String>,
        position: Int
    ): List<String> {
        var co2ScrubberInput = input
        val bits = getBitsByPosition(co2ScrubberInput)[position] ?: listOf()
        co2ScrubberInput = if (bits.count { it == 1 } >= bits.count { it == 0 }) {
            co2ScrubberInput.filter { it[position].toString() == "0" }
        } else {
            co2ScrubberInput.filter { it[position].toString() == "1" }
        }
        return co2ScrubberInput
    }

    private fun getBitsByPosition(input: List<String>): MutableMap<Int, MutableList<Int>> {
        val bitsByPosition: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        input.map { bit ->
            bit.forEachIndexed { position, char ->
                bitsByPosition[position]?.add(char.digitToInt()) ?: bitsByPosition.put(
                    position,
                    mutableListOf(char.digitToInt())
                )
            }
        }
        return bitsByPosition
    }
}
