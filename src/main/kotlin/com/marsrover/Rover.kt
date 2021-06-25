package com.marsrover

data class Rover(var position: Position, var direction: Direction) {
    fun move() {
        position = Position(position.row + direction.rowIncrement, position.column + direction.columnIncrement)
    }

    fun turnLeft() {
        direction = direction.left()
    }

    fun turnRight() {
        direction = direction.right()
    }
}
