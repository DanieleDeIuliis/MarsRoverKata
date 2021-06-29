package com.marsrover

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
        val output =  outputPrefix + finalFormattedState()
        ioStream.writeOutput(output)
    }

    private fun finalFormattedState(): String {
        val finalState = marsRover.finalState()
        return "${finalState.position.row}:${finalState.position.column}:${finalState.direction.name}"
    }
}

