package com.eveerkamp.aoc.day9

import com.eveerkamp.aoc.utils.readFile

class Day9Part1 {
    private var input = readFile("day9/input.txt")
        .lines()
        .mapIndexed { index, line -> index to line.toCharArray().toList().map { it.digitToInt() } }.toMap()


    fun calculate(): Int {
        return input.map { (index, line) ->
            line.mapIndexed { indexInLine, nr ->
                val up = if (index > 0) input[index - 1]!![indexInLine] else 9
                val down = if (index < input.size-1) input[index + 1]!![indexInLine] else 9
                val left = if (indexInLine > 0) input[index]!![indexInLine - 1] else 9
                val right = if (indexInLine < line.size-1) input[index]!![indexInLine + 1] else 9
                if(up > nr && down > nr && left > nr && right > nr){
                    println("$index, $indexInLine -> $nr")
                    nr+1
                } else{
                    0
                }
            }.sum()
        }.sum()
    }
}

