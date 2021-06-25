package com.marsrover

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarsRoverTest {
    @Test
    fun `move a rover up`() {
        val rover = Rover(position = Position(row = 0, column = 0), direction = Direction.UP)

        MarsRover(rover).move(Direction.UP)

        assertThat(rover.direction).isEqualTo(Direction.UP)
        assertThat(rover.position).isEqualTo(Position(row = 1, column = 0))
    }
}
