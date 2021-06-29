package com.marsrover

import com.marsrover.Direction.*
import com.marsrover.TurnDirection.*

interface Command {
    fun execute()
}

class Move(private val marsRover: MarsRover): Command {
    override fun execute() {
        marsRover.move()
    }
}

class Turn(private val marsRover: MarsRover, private val turnDirection: TurnDirection): Command {
    override fun execute() {
        marsRover.turn(turnDirection)
    }
}

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

    private fun parseCommands(input: String): List<Command> {
        return input.map { command(it) }
    }

    private fun command(singleCommand: Char) = when (singleCommand) {
        'M' -> Move(marsRover)
        'L' -> Turn(marsRover, LEFT)
        else -> Turn(marsRover, RIGHT)
    }

    private fun executeCommands() {
        parseCommands(ioStream.readInput()).forEach { it.execute() }
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

