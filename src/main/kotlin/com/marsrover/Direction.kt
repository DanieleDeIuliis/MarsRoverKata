package com.marsrover

enum class Direction(val rowIncrement: Int, val columnIncrement: Int) {

    N(1, 0) {
        override fun toLeft(): Direction = W
        override fun toRight(): Direction = E
    },
    S(-1, 0) {
        override fun toLeft(): Direction = E
        override fun toRight(): Direction = W
    },
    E(0, 1) {
        override fun toLeft(): Direction = N
        override fun toRight(): Direction = S
    },
    W(0, -1) {
        override fun toLeft(): Direction = N
        override fun toRight(): Direction = S
    };

    abstract fun toLeft(): Direction
    abstract fun toRight(): Direction
}

enum class TurnDirection {
    L, R;
}