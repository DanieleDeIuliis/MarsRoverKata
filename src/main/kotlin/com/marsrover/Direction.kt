package com.marsrover

enum class Direction(val rowIncrement: Int, val columnIncrement: Int) {

    N(1,0),
    S(-1,0),
    E(0,1),
    W(0,-1)
}