package com.marsrover

import com.marsrover.Direction.Companion.UP

class MarsRover(private val rover: Rover) {
    fun move(direction: Direction) {
        if (wouldGoOutside(direction)) return
        rover.move(direction)
    }

    private fun wouldGoOutside(direction: Direction): Boolean {
        if (direction == UP && rover.position.row >= 9) {
            return true
        }
        return false
    }

}
