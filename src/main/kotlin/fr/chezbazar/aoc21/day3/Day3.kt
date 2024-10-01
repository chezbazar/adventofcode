package fr.chezbazar.aoc21.day3

import fr.chezbazar.computeFrom
import kotlin.math.pow

fun main() {
    day3()
    day3PartTwo()
}

fun day3() {
    val ones = MutableList(12) {0}
    val zeros = MutableList(12) {0}
    computeFrom("aoc21/day3/input.txt") {
        it.forEachIndexed { index, c ->
            when(c) {
                '0' -> zeros[index]++
                '1' -> ones[index]++
            }
        }
    }
    val binaryGammaRate = List(12) {index -> if (ones[index] > zeros[index]) 1 else 0 }
    println()
    val gammaRate = binaryGammaRate.binaryToNumber()
    val epsilonRate = 4095 - gammaRate
    println("$gammaRate * $epsilonRate = ${gammaRate * epsilonRate}")
}

fun day3PartTwo() {
    val data = mutableListOf<String>()
    computeFrom("aoc21/day3/input.txt") {
        data.add(it)
    }
    var oxygenGeneratorRating: List<String> = data
    var co2ScrubberRating: List<String> = data
    for (i in 0..<12) {
        val sumOxy = oxygenGeneratorRating.sumOf { it[i].digitToInt() }
        oxygenGeneratorRating = if (sumOxy >= oxygenGeneratorRating.size / 2.0) {
            oxygenGeneratorRating.filter { it[i] == '1' }
        } else {
            oxygenGeneratorRating.filter { it[i] == '0' }
        }

        val sumCo = co2ScrubberRating.sumOf { it[i].digitToInt() }
        co2ScrubberRating = if (sumCo >= co2ScrubberRating.size / 2.0 && co2ScrubberRating.size > 1) {
            co2ScrubberRating.filter { it[i] == '0' }
        } else if (co2ScrubberRating.size > 1) {
            co2ScrubberRating.filter { it[i] == '1' }
        } else {
            co2ScrubberRating
        }
    }
    val ogr = oxygenGeneratorRating[0].map { it.digitToInt() }.binaryToNumber()
    val csr = co2ScrubberRating[0].map { it.digitToInt() }.binaryToNumber()
    println("$ogr * $csr = ${ogr * csr}")
}

fun List<Int>.binaryToNumber() = this.reversed().reduceIndexed { index, acc, i -> acc + i * 2.0.pow(index).toInt() }