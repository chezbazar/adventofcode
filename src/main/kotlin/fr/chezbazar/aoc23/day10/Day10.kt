package fr.chezbazar.aoc23.day10

import fr.chezbazar.aoc23.CardinalDirection
import fr.chezbazar.aoc23.Point
import fr.chezbazar.computeFrom

fun main() {
    val map = mutableListOf<MutableList<Pipe>>()
    computeFrom("aoc23/day10/input.txt") { line ->
        map.add(line.map { Pipe.from(it) }.toMutableList())
    }
    val loop = map.findLoop()
    println(loop.size / 2)
    println(map.enclosedPoints(loop))
}

fun List<MutableList<Pipe>>.findLoop(): List<Point> {
    var (currentPoint, currentDirection) = this.findStart()
    val loop = mutableListOf<Point>()
    while (!loop.contains(currentPoint)) {
        loop.add(currentPoint)
        currentDirection = this[currentPoint.y][currentPoint.x].comingFrom(currentDirection)
        currentPoint += currentDirection
        currentDirection = currentDirection.opposite()
    }
    return loop
}

fun List<MutableList<Pipe>>.findStart(): Pair<Point, CardinalDirection> {
    val y = this.indexOfFirst { it.contains(Pipe.START) }
    val x = this[y].indexOf(Pipe.START)
    // S is not on an edge so not bothering with this case
    this[y][x] = if (this[y-1][x].connectsTo(CardinalDirection.SOUTH) && this[y+1][x].connectsTo(CardinalDirection.NORTH)) {
        Pipe.VERTICAL
    } else if (this[y][x-1].connectsTo(CardinalDirection.EAST) && this[y][x+1].connectsTo(CardinalDirection.WEST)) {
        Pipe.HORIZONTAL
    } else if (this[y-1][x].connectsTo(CardinalDirection.SOUTH) && this[y][x+1].connectsTo(CardinalDirection.WEST)) {
        Pipe.NORTHEASTBEND
    } else if (this[y-1][x].connectsTo(CardinalDirection.SOUTH) && this[y][x-1].connectsTo(CardinalDirection.EAST)) {
        Pipe.NORTHWESTBEND
    } else if (this[y+1][x].connectsTo(CardinalDirection.NORTH) && this[y][x-1].connectsTo(CardinalDirection.EAST)) {
        Pipe.SOUTHWESTBEND
    } else if (this[y+1][x].connectsTo(CardinalDirection.NORTH) && this[y][x+1].connectsTo(CardinalDirection.WEST)) {
        Pipe.SOUTHEASTBEND
    } else {
        throw Error()
    }
    return Point(x, y) to this[y][x].ways!!.first
}

fun List<List<Pipe>>.enclosedPoints(loop: List<Point>) : Int {
    var total = 0
    this.forEachIndexed { y, pipes ->
        var inLoop = false
        var inBorderFromBelow = false
        var inBorderFromAbove = false
        pipes.forEachIndexed { x, pipe ->
            if (loop.contains(Point(x, y))) {
                // Handle pipe
                when(pipe) {
                    Pipe.VERTICAL -> {
                        inBorderFromAbove = false
                        inBorderFromBelow = false
                        inLoop = !inLoop
                    }
                    Pipe.SOUTHEASTBEND -> {
                        inBorderFromAbove = false
                        inBorderFromBelow = true
                    }
                    Pipe.SOUTHWESTBEND -> {
                        if (inBorderFromAbove) {
                            inLoop = !inLoop
                        }
                        inBorderFromAbove = false
                        inBorderFromBelow = false
                    }
                    Pipe.NORTHWESTBEND -> {
                        if (inBorderFromBelow) {
                            inLoop = !inLoop
                        }
                        inBorderFromAbove = false
                        inBorderFromBelow = false
                    }
                    Pipe.NORTHEASTBEND -> {
                        inBorderFromAbove = true
                        inBorderFromBelow = false
                    }
                    else -> {}
                }
            } else if (inLoop) {
                total++
            }
        }
    }
    return total
}