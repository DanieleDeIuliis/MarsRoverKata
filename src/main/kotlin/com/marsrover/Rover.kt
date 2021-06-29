package com.marsrover

class Rover(var position: Position, var state: State) {
    fun move() {
        position = nextPosition()
    }

    fun turnLeft() {
        state.goLeft(this)
    }

    fun turnRight() {
        state.goRight(this)
    }

    fun nextPosition(): Position {
        return state.nextPosition(this)
    }

}

