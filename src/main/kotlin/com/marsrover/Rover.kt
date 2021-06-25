package com.marsrover

data class Rover(var position: Position, var direction: Direction) {
    fun move(direction: Direction) {
        this.direction = direction
        position = Position(position.row + direction.rowIncrement, position.column + direction.columnIncrement)
    }
}
