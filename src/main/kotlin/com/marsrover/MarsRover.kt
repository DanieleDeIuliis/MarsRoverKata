package com.marsrover

import com.marsrover.Direction.Companion.DOWN
import com.marsrover.Direction.Companion.UP

class MarsRover(private val rover: Rover) {
    fun move(direction: Direction) {
        if (wouldGoOutside(direction)) return
        rover.move(direction)
    }

    private fun wouldGoOutside(direction: Direction): Boolean {
        if (direction == UP && rover.position.row >= 9) {
            return true
        } else if (direction == DOWN && rover.position.row <= 0) {
            return true
        }
        return false
    }

}
