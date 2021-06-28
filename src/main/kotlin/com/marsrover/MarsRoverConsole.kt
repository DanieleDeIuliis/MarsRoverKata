package com.marsrover

import com.marsrover.TurnDirection.*

class MarsRoverConsole(private val ioStream: IOStream, private val marsRover: MarsRover) {
    fun moveRoverOnMars() {
        val input = ioStream.readInput()
        input.forEach { command ->
            if(command == 'M') {
                marsRover.move()
            } else if(command == 'L') {
                marsRover.turn(LEFT)
            }
        }
        val output = marsRover.finalPosition()
        ioStream.writeOutput(output)
    }

}
