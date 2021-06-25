package com.marsrover

data class Rover(var position: Position, var direction: Direction) {
    fun move(direction: Direction) {
        this.direction = direction
        if (direction == Direction.UP) {
            position = Position(position.row + 1, position.column)
        }
    }
}
