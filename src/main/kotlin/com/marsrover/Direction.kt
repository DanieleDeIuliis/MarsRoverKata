package com.marsrover

data class Direction(val rowIncrement: Int, val columnIncrement: Int) {
    companion object {
        val UP = Direction(1, 0)
        val DOWN: Direction = Direction(-1, 0)
        val EAST: Direction = Direction(0, 1)
    }
}