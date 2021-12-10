package com.eveerkamp.aoc

import com.eveerkamp.aoc.day10.Day10Part1
import com.eveerkamp.aoc.day10.Day10Part2
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdventOfCode

fun main(args: Array<String>) {
    runApplication<AdventOfCode>(*args)
    println("Result ${Day10Part2().calculate()}")
}