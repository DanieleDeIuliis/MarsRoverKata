package com.marsrover

class MarsRover(private val rover: Rover) {

    fun move(direction: Direction) {
        if (wouldGoOutside(direction)) return
        rover.move(direction)
    }

    private fun wouldGoOutside(direction: Direction): Boolean {
        val positionAfterMove = Position(rover.position.row + direction.rowIncrement, rover.position.column + direction.columnIncrement)
        return !isPositionInRange(positionAfterMove)
    }

    private fun isPositionInRange(position: Position) = position.row in 0..9 && position.column in 0..9


}
