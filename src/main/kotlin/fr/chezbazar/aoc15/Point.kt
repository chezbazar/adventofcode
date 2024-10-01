package fr.chezbazar.aoc15

data class Point(val x: Int, val y: Int) {
    fun moveRight() = Point(x + 1, y)
    fun moveLeft() = Point(x - 1, y)
    fun moveUp() = Point(x, y + 1)
    fun moveDown() = Point(x, y - 1)
}
