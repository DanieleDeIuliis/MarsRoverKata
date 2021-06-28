package com.marsrover

class MarsRoverConsole(private val ioStream: IOStream, private val marsRover: MarsRover) {
    fun moveRoverOnMars() {
        val input = ioStream.readInput()
        input.forEach { command ->
            if(command == 'M') {
                marsRover.move()
            }
        }
        val output = marsRover.finalPosition()
        ioStream.writeOutput(output)
    }

}
