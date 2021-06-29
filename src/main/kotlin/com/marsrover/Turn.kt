package com.marsrover

class Turn(private val marsRover: MarsRover, private val turnDirection: TurnDirection): Command {
    override fun execute() {
        marsRover.turn(turnDirection)
    }
}