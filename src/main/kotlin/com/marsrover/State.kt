package com.marsrover

sealed interface State {
    fun goLeft(rover: Rover)
    fun goRight(rover: Rover)
    fun nextPosition(rover: Rover): Position
}

object East : State {
    override fun goLeft(rover: Rover) {
        rover.state = North
    }

    override fun goRight(rover: Rover) {
        rover.state = South
    }

    override fun nextPosition(rover: Rover): Position {
        return Position(rover.position.row, rover.position.column + 1)
    }
}

object North : State {
    override fun goLeft(rover: Rover) {
        rover.state = West
    }

    override fun goRight(rover: Rover) {
        rover.state = East
    }

    override fun nextPosition(rover: Rover): Position {
        return Position(rover.position.row + 1, rover.position.column)
    }
}

object South : State {
    override fun goLeft(rover: Rover) {
        rover.state = East
    }

    override fun goRight(rover: Rover) {
        rover.state = West
    }

    override fun nextPosition(rover: Rover): Position {
        return Position(rover.position.row - 1, rover.position.column)
    }
}

object West : State {
    override fun goLeft(rover: Rover) {
        rover.state = South
    }

    override fun goRight(rover: Rover) {
        rover.state = North
    }

    override fun nextPosition(rover: Rover): Position {
        return Position(rover.position.row, rover.position.column - 1)
    }
}