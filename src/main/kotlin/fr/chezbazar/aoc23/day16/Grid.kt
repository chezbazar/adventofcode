package fr.chezbazar.aoc23.day16

import fr.chezbazar.aoc23.Direction
import fr.chezbazar.aoc23.Point

class Grid(private val tiles: List<List<Tile>>) {
    companion object {
        fun from(input: List<String>) = Grid(input.map { s -> s.map { Tile.from(it) } })
    }

    fun sendRay(position: Point, direction: Direction) {
        getTileAt(position)?.lightFrom(direction)?.forEach { newDirection ->
            sendRay(position + newDirection, newDirection)
        }
    }

    private fun getTileAt(point: Point) = if (tiles.indices.contains(point.y) && tiles[point.y].indices.contains(point.x)) {
        tiles[point.y][point.x]
    } else {
        null
    }

    fun totalEnergized() = tiles.sumOf { line -> line.filter { it.isEnergized() }.size }
}