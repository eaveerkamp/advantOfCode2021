package com.eveerkamp.aoc.day5

class Line(
    val x: Pair<Int, Int>,
    val y: Pair<Int, Int>
) {
    val horizontalOrVerticalLine = (x.first == x.second) || (y.first == y.second)

    override fun toString(): String {
        return "Line $x, $y"
    }
}