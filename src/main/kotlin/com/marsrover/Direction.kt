package com.marsrover

data class Direction(val rowIncrement: Int, val columnIncrement: Int) {
    companion object {
        val UP = Direction(1, 0)
    }
}