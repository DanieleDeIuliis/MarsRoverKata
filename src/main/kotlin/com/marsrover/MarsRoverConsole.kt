package com.marsrover

class MarsRoverConsole(private val ioStream: IOStream, private val marsRover: MarsRover, private val ioParser: IOParser = IOParser(marsRover)) {

    fun moveRoverOnMars() {
        var obstacleEncountered = false
        try {
            executeCommands()
        } catch (e: ObstacleInPositionException) {
            obstacleEncountered = true
        }
        val output = ioParser.formatOutput(obstacleEncountered)
        ioStream.writeOutput(output)
    }

    private fun executeCommands() {
        ioParser.parseCommands(ioStream.readInput()).forEach { it.execute() }
    }
}

