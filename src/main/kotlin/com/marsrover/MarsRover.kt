package com.marsrover

import com.marsrover.TurnDirection.*

class MarsRover(private val rover: Rover, private val grid: Grid) {

    fun move() {
        val nextPosition = rover.nextPosition()
        if (nextPosition.isValid()) {
            rover.move()
        }
    }

    fun turn(direction: TurnDirection) {
        when (direction) {
            LEFT -> rover.turnLeft()
            R -> rover.turnRight()
        }
    }

    fun finalPosition(): String {
        TODO("Not yet implemented")
    }

    private fun Position.isValid(): Boolean = isPositionInRange(this) && grid.isAvailable(this)
    private fun isPositionInRange(position: Position) = position.row in 0 until grid.rows && position.column in 0 until grid.columns


}
