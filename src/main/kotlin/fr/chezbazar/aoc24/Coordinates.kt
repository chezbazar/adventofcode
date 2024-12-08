package fr.chezbazar.aoc24

data class Coordinates(val x: Int, val y: Int) {
    operator fun plus(coordinates: Coordinates) = Coordinates(x + coordinates.x, y + coordinates.y)
    operator fun minus(coordinates: Coordinates) = Coordinates(x - coordinates.x, y - coordinates.y)
    operator fun times(factor: Int) = Coordinates(x * factor, y * factor)
}
