package com.marsrover

class Move(private val marsRover: MarsRover): Command {
    override fun execute() {
        marsRover.move()
    }
}