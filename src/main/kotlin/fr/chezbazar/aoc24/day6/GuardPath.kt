package fr.chezbazar.aoc24.day6

import fr.chezbazar.aoc24.Direction

class GuardPath(val grid: List<List<Tile>>, private val startingCoordinates: Pair<Int, Int>) {
    enum class TileType {
        PATH,
        OBSTACLE
    }

    data class Tile(val type: TileType, var visited: Boolean = false)

    companion object {
        fun from(entry: List<String>): GuardPath {
            val grid = mutableListOf<List<Tile>>()
            var startingCoordinates = 0 to 0
            entry.forEachIndexed { i, line ->
                grid.add(line.mapIndexed { j, c ->
                    when(c) {
                        '.' -> Tile(TileType.PATH)
                        '#' -> Tile(TileType.OBSTACLE)
                        '^' -> {
                            startingCoordinates = i to j
                            Tile(TileType.PATH)
                        }

                        else -> throw Exception()
                    }
                })
            }
            return GuardPath(grid, startingCoordinates)
        }
    }

    fun patrol() {
        var currentCoordinates = startingCoordinates
        var currentDirection = Direction.UP
        while (inGrid(currentCoordinates)) {
            visitTile(currentCoordinates)
            val nextCoordinates = when(currentDirection) {
                Direction.RIGHT -> currentCoordinates.first to currentCoordinates.second + 1
                Direction.UP -> currentCoordinates.first - 1 to currentCoordinates.second
                Direction.DOWN -> currentCoordinates.first + 1 to currentCoordinates.second
                Direction.LEFT -> currentCoordinates.first to currentCoordinates.second - 1
            }
            if (inGrid(nextCoordinates) && tileAt(nextCoordinates).type == TileType.OBSTACLE) {
                currentDirection = currentDirection.rotateRight()
            } else {
                currentCoordinates = nextCoordinates
            }
        }
    }

    private fun visitTile(coordinates: Pair<Int, Int>) {
        val (i, j) = coordinates
        grid[i][j].visited = true
    }

    private fun inGrid(coordinates: Pair<Int, Int>): Boolean {
        val (i, j) = coordinates
        return i < grid.size && i >= 0 && j < grid[i].size && j >= 0
    }

    private fun tileAt(coordinates: Pair<Int, Int>) = grid[coordinates.first][coordinates.second]

    fun visitedTiles() = grid.flatMap { it.map { tile -> tile.visited } }.count { it }

    private fun loops(): Boolean {
        val allStates = mutableSetOf<Pair<Pair<Int, Int>, Direction>>()
        var currentCoordinates = startingCoordinates
        var currentDirection = Direction.UP
        while (inGrid(currentCoordinates)) {
            if (allStates.contains(currentCoordinates to currentDirection)) {
                return true
            }
            allStates.add(currentCoordinates to currentDirection)
            val nextCoordinates = when(currentDirection) {
                Direction.RIGHT -> currentCoordinates.first to currentCoordinates.second + 1
                Direction.UP -> currentCoordinates.first - 1 to currentCoordinates.second
                Direction.DOWN -> currentCoordinates.first + 1 to currentCoordinates.second
                Direction.LEFT -> currentCoordinates.first to currentCoordinates.second - 1
            }
            if (inGrid(nextCoordinates) && tileAt(nextCoordinates).type == TileType.OBSTACLE) {
                currentDirection = currentDirection.rotateRight()
            } else {
                currentCoordinates = nextCoordinates
            }
        }
        return false
    }

    fun loopingWays() = grid.flatMapIndexed { i, tiles -> tiles.mapIndexed { j, tile ->
        val coordinates = i to j
        if (coordinates != startingCoordinates && tile.visited) {
            val newGrid = List(grid.size) { i -> List(grid[i].size) { j -> if (coordinates == i to j) Tile(TileType.OBSTACLE) else tileAt(i to j) } }
            if (GuardPath(newGrid, startingCoordinates).loops()) {
                1
            } else {
                0
            }
        } else {
            0
        }
    } }.sum()
}