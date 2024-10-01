package fr.chezbazar.aoc23.day18

import fr.chezbazar.aoc23.Direction
import fr.chezbazar.aoc23.Point
import fr.chezbazar.aoc23.day10.Pipe
import fr.chezbazar.getBufferedReaderFrom

fun main() {
    val dugPoints = mutableListOf<Pair<Point, Pipe>>()
    val input = getBufferedReaderFrom("aoc23/day18/input.txt").readLines().digInfo()
    var currentPoint = Point(0,0)
    for (i in input.indices) {
        val (direction, amount) = input[i]
        val nextDirection = input[(i + 1) % input.size].first
        repeat(amount - 1) {
            currentPoint += direction
//            dugPoints.add(currentPoint to )
        }
    }
}

fun List<String>.digInfo() = this.map {
    val (dir, amount) = it.split(" ")
    val direction = when(dir) {
        "R" -> Direction.RIGHT
        "L" -> Direction.LEFT
        "U" -> Direction.UP
        else -> Direction.DOWN
    }
    direction to amount.toInt()
}