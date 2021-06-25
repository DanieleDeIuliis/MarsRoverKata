package com.marsrover

import com.marsrover.Direction.Companion.UP

class MarsRover(private val rover: Rover) {
    fun move(direction: Direction) {
        if(direction == UP && rover.position.row >= 9) {
            return
        }
        rover.direction = direction
        if(direction == UP) {
            rover.position = Position(rover.position.row + 1, rover.position.column)
        }
    }

}
