package com.marsrover

enum class Direction(val rowIncrement: Int, val columnIncrement: Int) {

    N(1, 0) {
        override fun left(): Direction = W
        override fun right(): Direction = E
    },
    S(-1, 0) {
        override fun left(): Direction = E
        override fun right(): Direction = W
    },
    E(0, 1) {
        override fun left(): Direction = N
        override fun right(): Direction = S
    },
    W(0, -1) {
        override fun left(): Direction = N
        override fun right(): Direction = S
    };

    abstract fun left(): Direction
    abstract fun right(): Direction
}

enum class TurnDirection {
    LEFT, R;
}