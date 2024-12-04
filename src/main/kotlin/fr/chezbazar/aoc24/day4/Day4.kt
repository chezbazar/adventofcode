package fr.chezbazar.aoc24.day4

import fr.chezbazar.*

fun main() {
    val entry = getBufferedReaderFrom("aoc24/day4/input.txt").readLines()
    println(entry.countXmas())
    println(entry.countCrossMas())
}

fun List<String>.countXmas(): Int {
    var result = 0
    val xmas = "XMAS"
    result += this.lines().sumOf { it.countOccurrencesOf(xmas) + it.reversed().countOccurrencesOf(xmas) }
    result += this.columns().sumOf { it.countOccurrencesOf(xmas) + it.reversed().countOccurrencesOf(xmas) }
    result += this.diagonalsLeft().sumOf { it.countOccurrencesOf(xmas) + it.reversed().countOccurrencesOf(xmas) }
    result += this.diagonalsRight().sumOf { it.countOccurrencesOf(xmas) + it.reversed().countOccurrencesOf(xmas) }
    return result
}

fun List<String>.countCrossMas(): Int {
    var result = 0
    val ms = listOf('M', 'S')
    for (i in this.indices) {
        for (j in this[i].indices) {
            if (this[i][j] == 'A' &&
                i > 0 && j > 0 && i < this.lastIndex && j < this[i + 1].lastIndex && arrayOf(this[i - 1][j - 1],this[i + 1][j + 1]).sorted() == ms &&
                arrayOf(this[i - 1][j + 1],this[i + 1][j - 1]).sorted() == ms) {
                result++
            }
        }
    }
    return result
}