package com.eveerkamp.aoc

import com.eveerkamp.aoc.day7.Day7Part2
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdventOfCode

fun main(args: Array<String>) {
    runApplication<AdventOfCode>(*args)
    println("Result ${Day7Part2().calculate()}")
}