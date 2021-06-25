package com.marsrover

class Grid(val rows: Int, val columns: Int, obstacles: List<Position>) {
    private val cells: Array<Array<Boolean>> = Array(rows) { Array(columns) { true } }

    init {
        obstacles.forEach { obstacle ->
            cells[obstacle.row][obstacle.column] = false
        }
    }

    fun isAvailable(position: Position): Boolean {
        return cells[position.row][position.column]
    }
}
