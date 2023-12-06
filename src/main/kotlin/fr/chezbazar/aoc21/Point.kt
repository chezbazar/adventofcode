package fr.chezbazar.aoc21

import kotlin.math.abs
import kotlin.math.sign

data class Point(val x: Int, val y:Int) {
    operator fun plus(other: Point) = Point(this.x + other.x, this.y + other.y)

    fun rangeTo(other: Point) : List<Point> {
        val step = Point((other.x - this.x).sign, (other.y - this.y).sign)
        if ((abs(other.x - this.x) != abs(other.y - this.y)) && (this.x != other.x) && (this.y != other.y)) {
            throw Error("Invalid points $this and $other for a range")
        } else {
            val range = mutableListOf(this)
            var currentPoint = this
            while (currentPoint != other) {
                currentPoint += step
                range.add(currentPoint)
            }
            return range
        }
    }

    fun straightRangeTo(other: Point) = if ((this.x == other.x) || (this.y == other.y)) this.rangeTo(other) else listOf()
}
