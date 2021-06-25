package com.marsrover

class MarsRover(private val rover: Rover) {

    fun move(direction: Direction) {
        if (wouldGoOutside(direction)) return
        rover.move(direction)
    }

    private fun wouldGoOutside(direction: Direction): Boolean {
        if(rover.position.row + direction.rowIncrement in 9 downTo 0) {
            return false
        }
        return true
    }


}
