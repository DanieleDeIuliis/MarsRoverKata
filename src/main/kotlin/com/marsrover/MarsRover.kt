package com.marsrover

import com.marsrover.TurnDirection.*

class MarsRover(val state: RoverState, private val grid: Grid) {

    fun move() {
        val nextPosition = state.nextPosition()
        if (nextPosition.isValid()) {
            state.move()
        }
    }

    fun turn(direction: TurnDirection) {
        when (direction) {
            LEFT -> state.turnLeft()
            RIGHT -> state.turnRight()
        }
    }

    private fun Position.isValid(): Boolean = isPositionInRange(this) && grid.isAvailable(this)
    private fun isPositionInRange(position: Position) = position.row in 0 until grid.rows && position.column in 0 until grid.columns

}
