package fr.chezbazar.aoc21.day1

import fr.chezbazar.computeFrom

fun main() {
    val variations = mutableListOf<Int>()
    val allValues = mutableListOf<Int>()
    var currentValue: Int? = null
    computeFrom("aoc21/day1/input.txt") { line ->
        val newValue = line.toInt()
        allValues.add(newValue)
        if (currentValue != null) {
            variations.add(newValue - currentValue!!)
        }
        currentValue = newValue
    }
    println(variations.filter { it > 0 }.size)

    val buffers = List(allValues.size - 2) {index -> allValues.subList(index, index + 3).sum() }
    val bufferVariations = List(buffers.size - 1) {index -> buffers[index + 1] - buffers[index] }
    println(bufferVariations.filter { it > 0 }.size)
}