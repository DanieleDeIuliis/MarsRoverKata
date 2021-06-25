package com.marsrover

import com.marsrover.Direction.*
import com.marsrover.TurnDirection.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarsRoverTest {
    @Test
    fun `move a rover up`() {
        val rover = Rover(position = Position(row = 0, column = 0), direction = N)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(rover, grid).move()

        assertThat(rover.direction).isEqualTo(N)
        assertThat(rover.position).isEqualTo(Position(row = 1, column = 0))
    }

    @Test
    fun `a rover can't move up if the landing position is outside the grid`() {
        val rover = Rover(position = Position(row = 9, column = 0), direction = N)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(rover, grid).move()

        assertThat(rover.direction).isEqualTo(N)
        assertThat(rover.position).isEqualTo(Position(row = 9, column = 0))
    }

    @Test
    fun `move a rover down`() {
        val rover = Rover(position = Position(row = 9, column = 0), direction = S)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(rover, grid).move()

        assertThat(rover.direction).isEqualTo(S)
        assertThat(rover.position).isEqualTo(Position(row = 8, column = 0))
    }

    @Test
    fun `a rover can't move down if the landing position is outside the grid`() {
        val rover = Rover(position = Position(row = 0, column = 0), direction = S)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(rover, grid).move()

        assertThat(rover.direction).isEqualTo(S)
        assertThat(rover.position).isEqualTo(Position(row = 0, column = 0))
    }

    @Test
    fun `move a rover east`() {
        val rover = Rover(position = Position(row = 0, column = 0), direction = E)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(rover, grid).move()

        assertThat(rover.direction).isEqualTo(E)
        assertThat(rover.position).isEqualTo(Position(row = 0, column = 1))
    }

    @Test
    fun `a rover can't move east if the landing position is outside the grid`() {
        val rover = Rover(position = Position(row = 0, column = 9), direction = E)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(rover, grid).move()

        assertThat(rover.direction).isEqualTo(E)
        assertThat(rover.position).isEqualTo(Position(row = 0, column = 9))
    }

    @Test
    fun `move a rover west`() {
        val rover = Rover(position = Position(row = 0, column = 9), direction = W)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(rover, grid).move()

        assertThat(rover.direction).isEqualTo(W)
        assertThat(rover.position).isEqualTo(Position(row = 0, column = 8))
    }

    @Test
    fun `a rover can't move west if the landing position is outside the grid`() {
        val rover = Rover(position = Position(row = 0, column = 0), direction = W)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(rover, grid).move()

        assertThat(rover.direction).isEqualTo(W)
        assertThat(rover.position).isEqualTo(Position(row = 0, column = 0))
    }

    @Test
    fun `a rover can't move if in the landing position there's an obstacle`() {
        val rover = Rover(position = Position(row = 0, column = 0), direction = N)
        val grid = Grid(rows = 10, columns = 10, obstacles = listOf(Position(1,0)))
        MarsRover(rover, grid).move()

        assertThat(rover.direction).isEqualTo(N)
        assertThat(rover.position).isEqualTo(Position(row = 0, column = 0))
    }

    @Test
    fun `a rover can turn left`() {
        val rover = Rover(position = Position(row = 0, column = 0), direction = N)
        val grid = Grid(rows = 10, columns = 10, obstacles = listOf(Position(1,0)))

        MarsRover(rover, grid).turn(L)

        assertThat(rover.direction).isEqualTo(W)
    }
}

