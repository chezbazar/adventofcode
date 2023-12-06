package fr.chezbazar.aoc23

open class RectangularRange(val xRange: IntRange, val yRange: IntRange) {
    fun isAdjacentTo(other: RectangularRange) = xRange.intersect(other.xRange.widen()).isNotEmpty() && yRange.intersect(other.yRange.widen()).isNotEmpty()
}

fun IntRange.widen() = this.first - 1 .. this.last + 1