package com.eveerkamp.aoc

import com.eveerkamp.aoc.day5.Day5Part1
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdventOfCode

fun main(args: Array<String>) {
    runApplication<AdventOfCode>(*args)
    println("Result ${Day5Part1().calculate()}")
}