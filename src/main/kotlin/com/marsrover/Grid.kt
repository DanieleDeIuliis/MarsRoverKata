package com.marsrover

class Grid(val rows: Int, val columns: Int, obstacles: List<Position>) {
    private val cells: MutableSet<Position> = mutableSetOf()

    init {
        obstacles.forEach { cells.add(it) }
    }

    fun isAvailable(position: Position): Boolean {
        if(cells.contains(position)) {
            throw ObstacleInPositionException()
        }
        return true
    }
}
