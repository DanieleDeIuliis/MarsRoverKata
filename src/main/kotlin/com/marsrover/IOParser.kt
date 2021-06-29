package com.marsrover

class IOParser(private val marsRover: MarsRover) {

    fun parseCommands(input: String): List<Command> {
        return input.map { command(it) }
    }

    fun formatOutput(obstacledEncountered: Boolean): String {
        var prefix = ""
        if(obstacledEncountered) {
            prefix = "0:"
        }
        return prefix + marsRover.formattedFinalStateString()
    }

    private fun command(singleCommand: Char) = when (singleCommand) {
        'M' -> Move(marsRover)
        'L' -> Turn(marsRover, TurnDirection.LEFT)
        else -> Turn(marsRover, TurnDirection.RIGHT)
    }

    private fun MarsRover.formattedFinalStateString(): String {
        return rover.toFormattedString()
    }

    private fun Rover.toFormattedString(): String {
        return "${position.row}:${position.column}:${direction.parsedName()}"
    }

    private fun Direction.parsedName(): String {
        return when(this) {
            Direction.NORTH -> "N"
            Direction.SOUTH -> "S"
            Direction.EAST -> "E"
            Direction.WEST -> "W"
        }
    }
}