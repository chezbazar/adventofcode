package fr.chezbazar.aoc23.day16

import fr.chezbazar.aoc23.Direction

class Tile(private val type: TileType, private val lightBeams: MutableList<Direction> = mutableListOf()) {
    companion object {
        fun from(c: Char) = when(c) {
            '\\' -> Tile(TileType.LEFT_MIRROR)
            '/' -> Tile(TileType.RIGHT_MIRROR)
            '|' -> Tile(TileType.VERTICAL_SPLITTER)
            '-' -> Tile(TileType.HORIZONTAL_SPLITTER)
            else -> Tile(TileType.EMPTY_SPACE)
        }
    }
    fun isEnergized() = lightBeams.isNotEmpty()
    fun lightFrom(direction: Direction) = if (!lightBeams.contains(direction)) {
        lightBeams.add(direction)
        direction.deviateBy(type)
    } else {
        listOf()
    }
}