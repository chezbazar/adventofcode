package fr.chezbazar.aoc23

import fr.chezbazar.aoc23.day10.Direction

data class Point(val x: Int, val y: Int): RectangularRange(x..x, y..y) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
    operator fun plus(direction: Direction) = Point(x + direction.movement.first, y + direction.movement.second)
}
