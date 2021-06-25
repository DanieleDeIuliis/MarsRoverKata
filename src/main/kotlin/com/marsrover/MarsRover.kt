package com.marsrover

import com.marsrover.Direction.Companion.UP

class MarsRover(private val rover: Rover) {
    fun move(direction: Direction) {
        if(direction == UP && rover.position.row >= 9) {
            return
        }
        val aRover = rover
        aRover.move(direction)
    }

}
