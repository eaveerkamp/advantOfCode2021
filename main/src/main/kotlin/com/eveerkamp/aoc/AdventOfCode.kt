package com.eveerkamp.aoc

import com.eveerkamp.aoc.day8.Day8Part2
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdventOfCode

fun main(args: Array<String>) {
    runApplication<AdventOfCode>(*args)
    println("Result ${Day8Part2().calculate()}")
}