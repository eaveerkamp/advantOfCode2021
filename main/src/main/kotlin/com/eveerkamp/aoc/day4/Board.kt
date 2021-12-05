package com.eveerkamp.aoc.day4

data class Board(
    val index: Int,
    val rows: List<MutableList<Int>>,
    val columns: List<MutableList<Int>>,
    var winIndex: Int? = null
) {
    companion object{
        fun getBoards(input: List<String>): List<Board> {
            val boardSize = 5
            return input.drop(2)
                .windowed(boardSize, boardSize + 1)
                .mapIndexed { boardIndex, board ->
                    val rows = board
                        .map { rowInput ->
                            rowInput
                                .split(" ")
                                .map { it.trim() }
                                .filter { it.isNotBlank() }
                                .map { it.toInt() }
                                .toMutableList()
                        }
                    val columns: MutableList<MutableList<Int>> = mutableListOf()
                    for (i in 0 until boardSize)
                        columns.add(rows.map { row -> row[i] }
                            .toMutableList())
                    Board(boardIndex, rows, columns)
                }
        }
    }

    fun drawInRow(number: Int): Boolean = draw(rows, number)

    fun drawInColumn(number: Int): Boolean = draw(columns, number)

    fun sumOfRemaining() = rows.flatten().sum()

    private fun draw(list: List<MutableList<Int>>, number: Int): Boolean {
        list.forEach { line ->
            line.removeIf { it == number }
            if (line.size == 0) {
                return true
            }
        }
        return false
    }
}