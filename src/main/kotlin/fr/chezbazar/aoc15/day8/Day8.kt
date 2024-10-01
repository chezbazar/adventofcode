package fr.chezbazar.aoc15.day8

import fr.chezbazar.computeFrom

fun main() {
    var resultMemory = 0
    var resultNewlyEncoded = 0
    computeFrom("aoc15/day8/input.txt") {
        resultMemory += it.length - it.inMemorySize()
        resultNewlyEncoded += it.newlyEncoded() - it.length
    }
    println(resultMemory)
    println(resultNewlyEncoded)
}

fun String.inMemorySize() = length - 2 - charactersToRemove()
fun String.newlyEncoded() = length + 2 + countOccurences("\"") + countOccurences("\\")

private fun String.countOccurences(substring: String) : Int {
    var count = 0
    var startIndex = 0

    while (startIndex < length) {
        val index = indexOf(substring, startIndex)
        if (index >= 0) {
            count++
            startIndex = index + substring.length
        } else {
            break
        }
    }

    return count
}

private fun String.charactersToRemove(): Int {
    var count = 0
    var currentIndex = 0
    while (currentIndex < lastIndex) {
        if (this[currentIndex] == '\\') {
            if (this[currentIndex + 1] == 'x') {
                count += 3
                currentIndex += 4
            } else {
                count++
                currentIndex += 2
            }
        } else {
            currentIndex++
        }
    }
    return count
}