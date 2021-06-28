package com.marsrover

interface IOStream {
    fun readInput(): String
    fun writeOutput(output: String)
}