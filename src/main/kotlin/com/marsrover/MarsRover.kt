package com.marsrover

import com.marsrover.TurnDirection.*

class MarsRover(private val rover: Rover, private val grid: Grid) {

    fun move() {
        if (nextPosition(rover.direction).isValid()) {
            rover.move()
        }
    }

    fun turn(direction: TurnDirection) {
        when (direction) {
            L -> rover.turnLeft()
            R -> rover.turnRight()
        }
    }

    private fun Position.isValid(): Boolean = isPositionInRange(this) && grid.isAvailable(this)

    private fun nextPosition(direction: Direction) =
        Position(rover.position.row + direction.rowIncrement, rover.position.column + direction.columnIncrement)

    private fun isPositionInRange(position: Position) = position.row in 0..9 && position.column in 0..9


}
