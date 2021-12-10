package com.eveerkamp.aoc

import com.eveerkamp.aoc.day9.Day9Part1
import com.eveerkamp.aoc.day9.Day9Part2
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdventOfCode

fun main(args: Array<String>) {
    runApplication<AdventOfCode>(*args)
    println("Result ${Day9Part2().calculate()}")
}