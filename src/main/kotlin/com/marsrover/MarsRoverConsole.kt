package com.marsrover

import com.marsrover.TurnDirection.*

class MarsRoverConsole(private val ioStream: IOStream, private val marsRover: MarsRover) {
    fun moveRoverOnMars() {
        val input = ioStream.readInput()
        var output = ""
        input.forEach { command ->
            if(command == 'M') {
                try {
                    marsRover.move()
                } catch (e: ObstacleInPositionException) {
                    output = "0:"
                }
            } else if(command == 'L') {
                marsRover.turn(LEFT)
            } else if(command == 'R') {
                marsRover.turn(RIGHT)
            }
        }
        output += marsRover.finalPosition()
        ioStream.writeOutput(output)
    }

}
