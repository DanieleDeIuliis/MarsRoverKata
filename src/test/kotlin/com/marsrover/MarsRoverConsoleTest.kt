package com.marsrover

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
        every { marsRover.finalPosition() } returns "1:0:N"
        val marsRoverConsole = MarsRoverConsole(ioStream, marsRover)
        marsRoverConsole.moveRoverOnMars()
        verify { marsRover.move() }
        verify { ioStream.writeOutput("1:0:N") }
    }

    @Test
    fun `moves a rover north twice`() {
        every { ioStream.readInput() } returns "MM"
        every { marsRover.finalPosition() } returns "2:0:N"
        val marsRoverConsole = MarsRoverConsole(ioStream, marsRover)
        marsRoverConsole.moveRoverOnMars()
        verify(exactly = 2) { marsRover.move() }
        verify { ioStream.writeOutput("2:0:N") }
    }

    @Test
    fun `rotate a rover left`() {
        every { ioStream.readInput() } returns "L"
        every { marsRover.finalPosition() } returns "0:0:W"
        val marsRoverConsole = MarsRoverConsole(ioStream, marsRover)
        marsRoverConsole.moveRoverOnMars()
        verify { marsRover.turn(LEFT) }
        verify { ioStream.writeOutput("0:0:W") }
    }
}

