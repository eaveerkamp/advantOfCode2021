package com.eveerkamp.aoc.day5

import kotlin.math.atan2

class Line(
    val x: Pair<Int, Int>,
    val y: Pair<Int, Int>
) {
    val horizontalOrVerticalLine = (x.first == x.second) || (y.first == y.second)
    val diagonal =  Math.toDegrees(atan2((y.second - y.first).toDouble(), (x.second - x.first).toDouble()))

            override fun toString(): String {
        return "Line $x, $y"
    }
}