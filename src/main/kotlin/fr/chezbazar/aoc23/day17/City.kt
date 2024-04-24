package fr.chezbazar.aoc23.day17

import fr.chezbazar.aoc23.Direction
import fr.chezbazar.aoc23.Point

class City(private val blocks: List<List<Block>>) {
    fun dijkstra(): Int {
        reset()
        blocks.first().first().heatLossToStart[CrucibleLine(Direction.RIGHT, 0)] = 0
        blocks.first().first().heatLossToStart[CrucibleLine(Direction.DOWN, 0)] = 0
        val workCollection = mutableListOf(
            Point(0,0) to CrucibleLine(Direction.RIGHT, 0),
            Point(0,0) to CrucibleLine(Direction.DOWN, 0)
        )
        while (workCollection.isNotEmpty()) {
            workCollection.sortBy { (point, line) -> blockAt(point)!!.heatLossToStart[line] }
            val (point, line) = workCollection.removeAt(0)
            val currentHeatLoss = blockAt(point)!!.heatLossToStart[line]!!
            if (finalBlockMap().isNotEmpty() && currentHeatLoss >= finalBlockMap().values.min()) {
                // We can stop here
                return finalBlockMap().values.min()
            }
            for (directionLine in line.availableLines()) {
                blockAt(point + directionLine.direction)?.let {
                    if (!it.heatLossToStart.containsKey(directionLine) || it.heatLossToStart[directionLine]!! > currentHeatLoss + it.heatLoss) {
                        it.heatLossToStart[directionLine] = currentHeatLoss + it.heatLoss
                        workCollection.add((point + directionLine.direction) to directionLine)
                    }
                }
            }
        }
        return finalBlockMap().values.min()
    }

    private fun blockAt(point: Point) = if (point.isPositive() && point.y < blocks.size && point.x < blocks[point.y].size) {
        blocks[point.y][point.x]
    } else {
        null
    }

    private fun reset() = blocks.forEach { it.forEach { block -> block.heatLossToStart.clear() } }

    private fun finalBlockMap() = blocks.last().last().heatLossToStart.filterKeys { it.amount >= CrucibleLine.shortestLine }
}