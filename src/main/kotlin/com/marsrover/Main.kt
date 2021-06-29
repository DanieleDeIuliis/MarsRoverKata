package com.marsrover

import com.marsrover.Direction.*

fun main() {
    val ioStream = ConsoleIOStream()
    val initialState = RoverState(Position(0,0), NORTH)
    val grid = Grid(10,10, emptyList())
    val marsRover = MarsRover(initialState, grid)
    val marsRoverConsole = MarsRoverConsole(ioStream, marsRover)

    marsRoverConsole.moveRoverOnMars()
}