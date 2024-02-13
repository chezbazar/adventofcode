package fr.chezbazar.aoc23.day12

import fr.chezbazar.aoc23.computeFrom

private val knownCombinations = mutableMapOf<Pair<List<SpringStatus>, List<Int>>, Long>()

fun main() {
    val dataList = mutableListOf<Pair<List<SpringStatus>, List<Int>>>()
    computeFrom("day12/input.txt") { line ->
        dataList.add(getDataFromInputPart2(line))
    }
    println(dataList.sumOf { (statusList, brokenPattern) -> getCombination(statusList, brokenPattern) })
}

fun getDataFromInputPart1(input: String) = input.split(" ").let { (statusChain, brokenPattern) ->
    statusChain.map { SpringStatus.from(it) }.trim() to brokenPattern.split(",").map { it.toInt() }
}

fun getDataFromInputPart2(input: String) = input.split(" ").let { (statusChain, brokenPattern) ->
    List(5) { statusChain }.joinToString("?").map { SpringStatus.from(it) }.trim() to
    List(5) { brokenPattern }.joinToString(",").split(",").map { it.toInt() }
}

fun getCombination(statusList: List<SpringStatus>, brokenPattern: List<Int>) =
    knownCombinations.getOrPut(statusList to brokenPattern) { combinations(statusList, brokenPattern) }

private fun combinations(statusList: List<SpringStatus>, brokenPattern: List<Int>): Long {
    if (brokenPattern.isEmpty()) {
        // All broken springs have been placed, the combination is valid iff no further broken spring is known
        return if (statusList.none { it == SpringStatus.BROKEN }) {
            1L
        } else {
            0
        }
    } else {
        var result = 0L
        val nextBrokenNumber = brokenPattern.first()
        val workList = MutableList(2) {SpringStatus.OPERATIONAL}.apply { addAll(1, statusList) } // Surround with healthy springs for convenience
        val lastIndexToCheck = if (workList.contains(SpringStatus.BROKEN)) {
            minOf(
                workList.size - nextBrokenNumber,
                workList.indexOfFirst { it == SpringStatus.BROKEN }
            )
        } else {
            workList.size - nextBrokenNumber
        }
        for (i in 0..lastIndexToCheck) {
            if (workList.subList(i, i + nextBrokenNumber).none { it == SpringStatus.OPERATIONAL } && workList[i + nextBrokenNumber] != SpringStatus.BROKEN) {
                val nextList = workList.subList(i + nextBrokenNumber + 1, workList.size).trim()
                result += getCombination(nextList, brokenPattern.drop(1))
            }
        }
        return result
    }
}

private fun List<SpringStatus>.trim() = this.dropLastWhile { it == SpringStatus.OPERATIONAL }.dropWhile { it == SpringStatus.OPERATIONAL }