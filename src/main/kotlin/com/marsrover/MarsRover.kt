package com.marsrover

class MarsRover(private val rover: Rover, private val grid: Grid) {

    fun move(direction: Direction) {
        if (invalidMoveTo(direction)) return
        rover.move(direction)
    }

    private fun invalidMoveTo(direction: Direction): Boolean {
        return !isValid(nextPosition(direction))
    }

    private fun isValid(position: Position): Boolean = isPositionInRange(position) && grid.isAvailable(position)
    private fun nextPosition(direction: Direction) =
        Position(rover.position.row + direction.rowIncrement, rover.position.column + direction.columnIncrement)

    private fun isPositionInRange(position: Position) = position.row in 0..9 && position.column in 0..9


}
