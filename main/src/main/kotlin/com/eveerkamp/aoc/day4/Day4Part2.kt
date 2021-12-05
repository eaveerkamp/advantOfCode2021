package com.eveerkamp.aoc.day4

import com.eveerkamp.aoc.day4.Board.Companion.getBoards
import com.eveerkamp.aoc.utils.readFile

class Day4Part2 {
    private val input = readFile("day4/input.txt")
        .lines()

    fun calculate(): Int {
        val drawNumbers = input.first().split(",").map { it.toInt() }
        val boards = getBoards(input)
        val drawLast = numberLastWinner(drawNumbers, boards)!!
        return drawLast * boards.first { it.winIndex == boards.count()-1 }.sumOfRemaining()
    }

    private fun numberLastWinner(
        drawNumbers: List<Int>,
        boards: List<Board>
    ): Int? {
        drawNumbers.forEach { draw ->
            boards.filter { it.winIndex == null }.forEach { board ->
                val winnerRow = board.drawInRow(draw)
                val winnerColumn = board.drawInColumn(draw)
                if (winnerRow || winnerColumn) {
                    board.winIndex = boards.count { it.winIndex != null }
                }

            }
            if (boards.maxOf { it.winIndex ?: 0 } == boards.count()-1) {
                return draw
            }
        }
        return null
    }
}

