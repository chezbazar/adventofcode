package fr.chezbazar.aoc23.day10

import fr.chezbazar.aoc23.CardinalDirection

enum class Pipe(val ways: Pair<CardinalDirection, CardinalDirection>?) {
    VERTICAL(CardinalDirection.NORTH to CardinalDirection.SOUTH),
    HORIZONTAL(CardinalDirection.WEST to CardinalDirection.EAST),
    NORTHEASTBEND(CardinalDirection.NORTH to CardinalDirection.EAST),
    NORTHWESTBEND(CardinalDirection.NORTH to CardinalDirection.WEST),
    SOUTHWESTBEND(CardinalDirection.SOUTH to CardinalDirection.WEST),
    SOUTHEASTBEND(CardinalDirection.SOUTH to CardinalDirection.EAST),
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

    fun comingFrom(direction: CardinalDirection) = when(direction) {
        ways?.first -> ways.second
        ways?.second -> ways.first
        else -> throw Error()
    }

    fun connectsTo(direction: CardinalDirection) = ways?.toList()?.contains(direction) ?: false
}