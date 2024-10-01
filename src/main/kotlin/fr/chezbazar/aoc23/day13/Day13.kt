package fr.chezbazar.aoc23.day13

import fr.chezbazar.getBufferedReaderFrom

fun main() {
    val patterns = mutableListOf<List<String>>()
    var currentPattern = mutableListOf<String>()
    getBufferedReaderFrom("aoc23/day13/input.txt").forEachLine { line ->
        if (line.isEmpty()) {
            patterns.add(currentPattern)
            currentPattern = mutableListOf()
        } else {
            currentPattern.add(line)
        }
    }
    if (currentPattern.isNotEmpty()) {
        patterns.add(currentPattern)
    }
    println(patterns.sumOf { it.score() })
    println(patterns.sumOf { it.smudgedScore() })
}

fun List<String>.score(): Long {
    // Look for vertical mirror
    val columns = List(this[0].length) { index -> this.map { it[index] } }.map { String(it.toCharArray()) }
    return columns.findSymmetries().sum() + 100L * this.findSymmetries().sum()
}

fun List<String>.smudgedScore(): Long {
    val columns = List(this[0].length) { index -> this.map { it[index] } }.map { String(it.toCharArray()) }
    return columns.findSmudgedSymmetries().sum() + 100L * this.findSmudgedSymmetries().sum()
}

fun List<String>.findSymmetries(): List<Int> {
    val result = mutableListOf<Int>()
    val candidates = List(this.size) { index -> index }.dropLast(1).filter { this[it] == this[it + 1] }
    candidates.forEach { i ->
        val left = this.subList(0, i + 1)
        val right = this.subList(i + 1, this.size).reversed()
        val size = minOf(left.size, right.size)
        if (left.subList(left.size - size, left.size) == right.subList(right.size - size, right.size)) {
            result.add(i + 1)
        }
    }
    return result
}

fun List<String>.findSmudgedSymmetries(): List<Int> {
    val result = mutableListOf<Int>()
    val candidates = List(this.size) { index -> index }.dropLast(1).filter {
        this[it].differencesFrom(this[it + 1]) <= 1
    }
    candidates.forEach { i ->
        val left = this.subList(0, i + 1)
        val right = this.subList(i + 1, this.size).reversed()
        val size = minOf(left.size, right.size)
        val workLeft = left.subList(left.size - size, left.size)
        val workRight = right.subList(right.size - size, right.size)
        val smudge = workLeft.mapIndexed { index, s -> s.differencesFrom(workRight[index]) }.sum()
        if (smudge == 1) {
            result.add(i + 1)
        }
    }
    return result
}

fun String.differencesFrom(other: String) = this.mapIndexed { index, c -> c != other[index] }.count { it }