package fr.chezbazar.aoc23

import kotlin.math.abs

data class Point(val x: Int, val y: Int): RectangularRange(x..x, y..y) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
    operator fun plus(direction: CardinalDirection) = Point(x + direction.movement.first, y + direction.movement.second)

    operator fun plus(direction: Direction) = this + direction.move

    fun distanceTo(other: Point) = abs(x - other.x) + abs(y - other.y)
}
