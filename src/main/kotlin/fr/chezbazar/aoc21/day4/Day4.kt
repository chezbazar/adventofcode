package fr.chezbazar.aoc21.day4

import fr.chezbazar.getBufferedReaderFrom

fun main() {
    val bufferedReader = getBufferedReaderFrom("aoc21/day4/input.txt")
    println("35 0  5".split(" ").filter { it.isNotEmpty() }.map { it.toInt() })
    val numbers = bufferedReader.readLine().split(",").map { it.toInt() }
    val grids = mutableListOf<BingoGrid>()
    var currentGrid = mutableListOf<List<Int>>()
    bufferedReader.readLine()
    bufferedReader.forEachLine { s ->
        if (s.isEmpty()) {
            grids.add(BingoGrid.from(currentGrid))
            currentGrid = mutableListOf()
        } else {
            currentGrid.add(s.split(" ").filter { it.isNotEmpty() }.map { it.toInt() })
        }
    }
    val scores = bingoGame(grids, numbers)
    println(scores.first())
    println(scores.last())
}

fun bingoGame(grids: List<BingoGrid>, numbers: List<Int>): List<Int> {
    val scores = mutableListOf<Int>()
    for (number in numbers) {
        for (grid in grids) {
            if (grid.tick(number)) {
                scores.add(number * grid.unmarked())
            }
        }
    }
    return scores
}