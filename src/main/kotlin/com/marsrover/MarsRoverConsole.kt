package com.marsrover

import com.marsrover.Direction.*
import com.marsrover.TurnDirection.*

class MarsRoverConsole(private val ioStream: IOStream, private val marsRover: MarsRover) {

    fun moveRoverOnMars() {
        var outputPrefix = ""
        try {
            executeCommands()
        } catch (e: ObstacleInPositionException) {
            outputPrefix = "0:"
        }
        val output = outputPrefix + marsRover.formattedFinalStateString()
        ioStream.writeOutput(output)
    }

    private fun executeCommands() {
        ioStream.readInput().forEach { command ->
            execute(command)
        }
    }

    private fun execute(command: Char) {
        when (command) {
            'M' -> marsRover.move()
            'L' -> marsRover.turn(LEFT)
            'R' -> marsRover.turn(RIGHT)
        }
    }

    private fun MarsRover.formattedFinalStateString(): String {
        return rover.toFormattedString()
    }

    private fun Rover.toFormattedString(): String {
        return "${position.row}:${position.column}:${direction.parsedName()}"
    }

    private fun Direction.parsedName(): String {
        return when(this) {
            NORTH -> "N"
            SOUTH -> "S"
            EAST -> "E"
            WEST -> "W"
        }
    }
}

