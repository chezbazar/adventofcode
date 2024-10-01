package fr.chezbazar.aoc23

import fr.chezbazar.aoc23.day16.TileType

enum class Direction(val move: Point) {
    UP(Point(0, -1)),
    RIGHT(Point(1,0)),
    DOWN(Point(0,1)),
    LEFT(Point(-1,0));

    fun deviateBy(tileType: TileType) = when(tileType) {
        TileType.EMPTY_SPACE -> listOf(this)
        TileType.RIGHT_MIRROR -> when(this) {
            UP -> listOf(RIGHT)
            RIGHT -> listOf(UP)
            DOWN -> listOf(LEFT)
            LEFT -> listOf(DOWN)
        }
        TileType.LEFT_MIRROR -> when(this) {
            UP -> listOf(LEFT)
            RIGHT -> listOf(DOWN)
            DOWN -> listOf(RIGHT)
            LEFT -> listOf(UP)
        }
        TileType.VERTICAL_SPLITTER -> when(this) {
            UP, DOWN -> listOf(this)
            RIGHT, LEFT -> listOf(UP, DOWN)
        }
        TileType.HORIZONTAL_SPLITTER -> when(this) {
            UP, DOWN -> listOf(RIGHT, LEFT)
            RIGHT, LEFT -> listOf(this)
        }
    }

    fun turnRight() = entries[(this.ordinal + 1).mod(entries.size)]
    fun turnLeft() = entries[(this.ordinal - 1).mod(entries.size)]

    fun toCardinal() = when(this) {
        RIGHT -> CardinalDirection.EAST
        LEFT -> CardinalDirection.WEST
        UP -> CardinalDirection.NORTH
        DOWN -> CardinalDirection.SOUTH
    }
}