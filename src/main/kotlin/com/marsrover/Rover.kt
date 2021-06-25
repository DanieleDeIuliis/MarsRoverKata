package com.marsrover

data class Rover(var position: Position, var direction: Direction) {
    fun move() {
        position = Position(position.row + direction.rowIncrement, position.column + direction.columnIncrement)
    }
}
