package fr.chezbazar.aoc24.day8

import fr.chezbazar.aoc24.Coordinates
import fr.chezbazar.getBufferedReaderFrom
import fr.chezbazar.pairs

fun main() {
    val antennas = mutableMapOf<Char, MutableList<Coordinates>>()
    val input = getBufferedReaderFrom("aoc24/day8/input.txt").readLines()
    val lines = input.size
    val columns = input[0].length
    input.forEachIndexed { index, line ->
        line.forEachIndexed { j, c ->
            if (c != '.') {
                antennas[c] = antennas.getOrDefault(c, mutableListOf())
                antennas[c]!!.add(Coordinates(j, index))
            }
        }
    }
    println(countAntinodes(antennas, lines, columns))
    println(countExtendedAntinodes(antennas, lines, columns))
}

fun antinodesFrom(firstAntenna: Coordinates, secondAntenna: Coordinates, lines: Int, columns: Int) = listOf(
    firstAntenna + (secondAntenna - firstAntenna) * 2,
    secondAntenna + (firstAntenna - secondAntenna) * 2
).filter { it.x in 0..<columns && it.y in 0..<lines }

fun extendedAntinodesFrom(firstAntenna: Coordinates, secondAntenna: Coordinates, lines: Int, columns: Int): List<Coordinates> {
    var result = mutableListOf<Coordinates>()
    var currentAntinode = secondAntenna
    while (currentAntinode.x in 0..<columns && currentAntinode.y in 0..<lines) {
        result.add(currentAntinode)
        currentAntinode += secondAntenna - firstAntenna
    }
    currentAntinode = firstAntenna
    while (currentAntinode.x in 0..<columns && currentAntinode.y in 0..<lines) {
        result.add(currentAntinode)
        currentAntinode += firstAntenna - secondAntenna
    }
    return result
}

fun countAntinodes(antennas: Map<Char, List<Coordinates>>, lines: Int, columns: Int) = antennas.values.flatMap { it.pairs().flatMap { (firstAntenna, secondAntenna) ->
    antinodesFrom(firstAntenna, secondAntenna, lines, columns)
} }.toSet().size

fun countExtendedAntinodes(antennas: Map<Char, List<Coordinates>>, lines: Int, columns: Int) = antennas.values.flatMap { it.pairs().flatMap { (firstAntenna, secondAntenna) ->
    extendedAntinodesFrom(firstAntenna, secondAntenna, lines, columns)
} }.toSet().size