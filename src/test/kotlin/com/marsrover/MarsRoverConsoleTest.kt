package com.marsrover

import com.marsrover.Direction.*
import com.marsrover.TurnDirection.*
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class MarsRoverConsoleTest {

    private val ioStream: IOStream = mockk(relaxed = true)
    private val marsRover: MarsRover = mockk(relaxed = true)

    @Test
    fun `moves a rover on mars with standard initialization`() {
        every { ioStream.readInput() } returns "M"
        every { marsRover.rover } returns Rover(Position(1,0), NORTH)
        val marsRoverConsole = MarsRoverConsole(ioStream, marsRover)
        marsRoverConsole.moveRoverOnMars()
        verify { marsRover.move() }
        verify { ioStream.writeOutput("1:0:N") }
    }

    @Test
    fun `moves a rover north twice`() {
        every { ioStream.readInput() } returns "MM"
        every { marsRover.rover } returns Rover(Position(2,0), NORTH)
        val marsRoverConsole = MarsRoverConsole(ioStream, marsRover)
        marsRoverConsole.moveRoverOnMars()
        verify(exactly = 2) { marsRover.move() }
        verify { ioStream.writeOutput("2:0:N") }
    }

    @Test
    fun `rotate a rover left`() {
        every { ioStream.readInput() } returns "L"
        every { marsRover.rover } returns Rover(Position(0,0), WEST)
        val marsRoverConsole = MarsRoverConsole(ioStream, marsRover)
        marsRoverConsole.moveRoverOnMars()
        verify { marsRover.turn(LEFT) }
        verify { ioStream.writeOutput("0:0:W") }
    }

    @Test
    fun `rotate a rover right`() {
        every { ioStream.readInput() } returns "R"
        every { marsRover.rover } returns Rover(Position(0,0), EAST)
        val marsRoverConsole = MarsRoverConsole(ioStream, marsRover)
        marsRoverConsole.moveRoverOnMars()
        verify { marsRover.turn(RIGHT) }
        verify { ioStream.writeOutput("0:0:E") }
    }

    @Test
    fun `a rover can't move over an obstacle`() {
        every { ioStream.readInput() } returns "M"
        every { marsRover.rover } returns Rover(Position(0,0), NORTH)
        every { marsRover.move() } throws ObstacleInPositionException()

        val marsRoverConsole = MarsRoverConsole(ioStream, marsRover)
        marsRoverConsole.moveRoverOnMars()

        verify { ioStream.writeOutput("0:0:0:N") }
    }
}

