package com.marsrover

import com.marsrover.Direction.*
import com.marsrover.TurnDirection.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MarsRoverTest {
    @Test
    fun `move a rover up`() {
        val roverState = RoverState(position = Position(row = 0, column = 0), direction = NORTH)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(roverState, grid).move()

        assertThat(roverState.direction).isEqualTo(NORTH)
        assertThat(roverState.position).isEqualTo(Position(row = 1, column = 0))
    }

    @Test
    fun `a rover can't move up if the landing position is outside the grid`() {
        val roverState = RoverState(position = Position(row = 9, column = 0), direction = NORTH)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(roverState, grid).move()

        assertThat(roverState.direction).isEqualTo(NORTH)
        assertThat(roverState.position).isEqualTo(Position(row = 9, column = 0))
    }

    @Test
    fun `move a rover down`() {
        val roverState = RoverState(position = Position(row = 9, column = 0), direction = SOUTH)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(roverState, grid).move()

        assertThat(roverState.direction).isEqualTo(SOUTH)
        assertThat(roverState.position).isEqualTo(Position(row = 8, column = 0))
    }

    @Test
    fun `a rover can't move down if the landing position is outside the grid`() {
        val roverState = RoverState(position = Position(row = 0, column = 0), direction = SOUTH)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(roverState, grid).move()

        assertThat(roverState.direction).isEqualTo(SOUTH)
        assertThat(roverState.position).isEqualTo(Position(row = 0, column = 0))
    }

    @Test
    fun `move a rover east`() {
        val roverState = RoverState(position = Position(row = 0, column = 0), direction = EAST)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(roverState, grid).move()

        assertThat(roverState.direction).isEqualTo(EAST)
        assertThat(roverState.position).isEqualTo(Position(row = 0, column = 1))
    }

    @Test
    fun `a rover can't move east if the landing position is outside the grid`() {
        val roverState = RoverState(position = Position(row = 0, column = 9), direction = EAST)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(roverState, grid).move()

        assertThat(roverState.direction).isEqualTo(EAST)
        assertThat(roverState.position).isEqualTo(Position(row = 0, column = 9))
    }

    @Test
    fun `move a rover west`() {
        val roverState = RoverState(position = Position(row = 0, column = 9), direction = WEST)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(roverState, grid).move()

        assertThat(roverState.direction).isEqualTo(WEST)
        assertThat(roverState.position).isEqualTo(Position(row = 0, column = 8))
    }

    @Test
    fun `a rover can't move west if the landing position is outside the grid`() {
        val roverState = RoverState(position = Position(row = 0, column = 0), direction = WEST)
        val grid = Grid(rows = 10, columns = 10, obstacles = emptyList())
        MarsRover(roverState, grid).move()

        assertThat(roverState.direction).isEqualTo(WEST)
        assertThat(roverState.position).isEqualTo(Position(row = 0, column = 0))
    }

    @Test
    fun `a rover can't move if in the landing position there's an obstacle`() {
        val roverState = RoverState(position = Position(row = 0, column = 0), direction = NORTH)
        val grid = Grid(rows = 10, columns = 10, obstacles = listOf(Position(1,0)))
        assertThrows<ObstacleInPositionException> { MarsRover(roverState, grid).move() }

        assertThat(roverState.direction).isEqualTo(NORTH)
        assertThat(roverState.position).isEqualTo(Position(row = 0, column = 0))
    }

    @Test
    fun `a rover can turn left`() {
        val roverState = RoverState(position = Position(row = 0, column = 0), direction = NORTH)
        val grid = Grid(rows = 10, columns = 10, obstacles = listOf(Position(1,0)))

        MarsRover(roverState, grid).turn(LEFT)

        assertThat(roverState.direction).isEqualTo(WEST)
    }

    @Test
    fun `a rover can turn right`() {
        val roverState = RoverState(position = Position(row = 0, column = 0), direction = NORTH)
        val grid = Grid(rows = 10, columns = 10, obstacles = listOf(Position(1,0)))

        MarsRover(roverState, grid).turn(RIGHT)

        assertThat(roverState.direction).isEqualTo(EAST)
    }
}

