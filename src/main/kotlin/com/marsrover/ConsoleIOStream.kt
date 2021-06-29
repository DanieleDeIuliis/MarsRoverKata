package com.marsrover

class ConsoleIOStream: IOStream {
    override fun readInput(): String {
        println("Please insert commands:")
        return readLine() ?: ""
    }

    override fun writeOutput(output: String) {
        println(output)
    }
}