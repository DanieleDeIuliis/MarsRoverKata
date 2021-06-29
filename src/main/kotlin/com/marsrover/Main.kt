package com.marsrover

fun main() {
    val ioStream = ConsoleIOStream()
    val initialState = Rover(Position(0,0), North)
    val grid = Grid(10,10, emptyList())
    val marsRover = MarsRover(initialState, grid)
    val marsRoverConsole = MarsRoverConsole(ioStream, marsRover)

    marsRoverConsole.moveRoverOnMars()
}