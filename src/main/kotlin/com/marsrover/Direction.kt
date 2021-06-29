package com.marsrover

enum class Direction(val rowIncrement: Int, val columnIncrement: Int) {

    NORTH(1, 0) {
        override fun left(): Direction = WEST
        override fun right(): Direction = EAST
    },
    SOUTH(-1, 0) {
        override fun left(): Direction = EAST
        override fun right(): Direction = WEST
    },
    EAST(0, 1) {
        override fun left(): Direction = NORTH
        override fun right(): Direction = SOUTH
    },
    WEST(0, -1) {
        override fun left(): Direction = NORTH
        override fun right(): Direction = SOUTH
    };

    abstract fun left(): Direction
    abstract fun right(): Direction
}

enum class TurnDirection {
    LEFT, RIGHT;
}