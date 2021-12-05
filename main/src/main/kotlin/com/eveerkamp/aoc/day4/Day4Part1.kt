package com.eveerkamp.aoc.day4

import com.eveerkamp.aoc.utils.readFile

class Day4Part1 {
    private val input = readFile("day4/input.txt")
        .lines()

    fun calculate(): Int {
        val drawNumbers = input.first().split(",").map { it.toInt() }
        val boards = Board.getBoards(input)

        val winningBoardWithNumbers = draw(drawNumbers, boards)
        return winningBoardWithNumbers.first!! * winningBoardWithNumbers.second!!.flatten().sum()
    }

    private fun draw(
        drawNumbers: List<Int>,
        boards: List<Board>
    ): Pair<Int?, List<MutableList<Int>>?> {
        drawNumbers.forEach { draw ->
            boards.forEach { board ->
                val winnerRow = board.drawInRow(draw)
                if(winnerRow) return Pair(draw, board.rows)
                val winnerColumn = board.drawInColumn(draw)
                if(winnerColumn) return Pair(draw, board.columns)
            }
        }
        return Pair(null, null)
    }
}

