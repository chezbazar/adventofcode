package fr.chezbazar.aoc15.day5

import fr.chezbazar.getBufferedReaderFrom

fun main() {
    println(getBufferedReaderFrom("aoc15/day5/input.txt").readLines().count { it.isNice() })
    println(getBufferedReaderFrom("aoc15/day5/input.txt").readLines().count { it.isReallyNice() })
}

fun String.isNice() = hasThreeVowels() && hasTwoConsecutiveLetters() && !hasNaughtyStrings()

private fun String.hasThreeVowels() = this.count { "aeiou".contains(it) } >= 3

private fun String.hasTwoConsecutiveLetters() = this.filterIndexed { index, c -> index > 0 && c == this[index - 1] }.isNotEmpty()

private fun String.hasNaughtyStrings() = listOf("ab", "cd", "pq", "xy").any {
    this.contains(it)
}

fun String.isReallyNice() = hasRepeatingPair() && hasTwinLetter()

private fun String.hasRepeatingPair(): Boolean {
    forEachIndexed { index, _ ->
        if (index != lastIndex) {
            val pair = slice(index..index + 1)
            val before = slice(0 until index)
            val after = slice(index + 2..lastIndex)
            if (before.contains(pair) || after.contains(pair)) {
                return true
            }
        }
    }
    return false
}

private fun String.hasTwinLetter() = this.filterIndexed { index, c -> index > 1 && c == this[index - 2] }.isNotEmpty()