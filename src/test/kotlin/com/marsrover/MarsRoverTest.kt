package com.marsrover

import com.marsrover.Direction.Companion.DOWN
import com.marsrover.Direction.Companion.UP
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarsRoverTest {
    @Test
    fun `move a rover up`() {
        val rover = Rover(position = Position(row = 0, column = 0), direction = UP)

        MarsRover(rover).move(UP)

        assertThat(rover.direction).isEqualTo(UP)
        assertThat(rover.position).isEqualTo(Position(row = 1, column = 0))
    }

    @Test
    fun `a rover can't move up if the landing position is outside the grid`() {
        val rover = Rover(position = Position(row = 9, column = 0), direction = UP)

        MarsRover(rover).move(UP)

        assertThat(rover.direction).isEqualTo(UP)
        assertThat(rover.position).isEqualTo(Position(row = 9, column = 0))
    }

    @Test
    fun `move a rover down`() {
        val rover = Rover(position = Position(row = 9, column = 0), direction = DOWN)

        MarsRover(rover).move(DOWN)

        assertThat(rover.direction).isEqualTo(DOWN)
        assertThat(rover.position).isEqualTo(Position(row = 8, column = 0))
    }

    @Test
    fun `a rover can't move down if the landing position is outside the grid`() {
        val rover = Rover(position = Position(row = 0, column = 0), direction = DOWN)

        MarsRover(rover).move(DOWN)

        assertThat(rover.direction).isEqualTo(DOWN)
        assertThat(rover.position).isEqualTo(Position(row = 0, column = 0))
    }
}

