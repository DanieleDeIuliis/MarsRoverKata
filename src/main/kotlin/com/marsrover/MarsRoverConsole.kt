package com.marsrover

import com.marsrover.Direction.*
import com.marsrover.TurnDirection.*
class MarsRoverConsole(private val ioStream: IOStream, private val marsRover: MarsRover) {
    fun moveRoverOnMars() {
        val input = ioStream.readInput()
        var outputPrefix = ""
        input.forEach { command ->
            when (command) {
                'M' -> try {
                        marsRover.move()
                    } catch (e: ObstacleInPositionException) {
                    outputPrefix = "0:"
                    }
                'L' -> marsRover.turn(LEFT)
                'R' -> marsRover.turn(RIGHT)
            }
        }
        val output =  outputPrefix + marsRover.formattedStateString()
        ioStream.writeOutput(output)
    }

    private fun MarsRover.formattedStateString(): String {
        return state.toFormattedString()
    }

    private fun RoverState.toFormattedString(): String {
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

