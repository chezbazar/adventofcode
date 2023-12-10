package fr.chezbazar.aoc23.day10

enum class Pipe(val ways: Pair<Direction, Direction>?) {
    VERTICAL(Direction.NORTH to Direction.SOUTH),
    HORIZONTAL(Direction.WEST to Direction.EAST),
    NORTHEASTBEND(Direction.NORTH to Direction.EAST),
    NORTHWESTBEND(Direction.NORTH to Direction.WEST),
    SOUTHWESTBEND(Direction.SOUTH to Direction.WEST),
    SOUTHEASTBEND(Direction.SOUTH to Direction.EAST),
    GROUND(null),
    START(null);

    companion object {
        fun from(c: Char) = when(c) {
            '|' -> VERTICAL
            '-' -> HORIZONTAL
            'L' -> NORTHEASTBEND
            'J' -> NORTHWESTBEND
            '7' -> SOUTHWESTBEND
            'F' -> SOUTHEASTBEND
            'S' -> START
            else -> GROUND
        }
    }

    fun comingFrom(direction: Direction) = when(direction) {
        ways?.first -> ways.second
        ways?.second -> ways.first
        else -> throw Error()
    }

    fun connectsTo(direction: Direction) = ways?.toList()?.contains(direction) ?: false
}