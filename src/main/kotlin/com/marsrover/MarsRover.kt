package com.marsrover

import com.marsrover.Direction.Companion.UP

class MarsRover(private val rover: Rover) {
    fun move(direction: Direction) {
        rover.direction = direction
        if(direction == UP) {
            rover.position = Position(rover.position.row + 1, rover.position.column)
        }
    }

}
