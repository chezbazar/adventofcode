package fr.chezbazar.aoc23.day4

import kotlin.math.pow

class Card(private val winningNumbers: List<Int>, private val numbersYouHave: List<Int>) {

    var amount = 1

    companion object {
        fun from(text: String): Card {
            val (_, numbers) = text.split(":")
            val (winningNumbersDescription, numbersYouHaveDescription) = numbers.split("|")
            val winningNumbers = winningNumbersDescription.trim().split(Regex("\\s+")).map { it.toInt() }
            val numbersYouHave = numbersYouHaveDescription.trim().split(Regex("\\s+")).map { it.toInt() }
            return Card(winningNumbers, numbersYouHave)
        }
    }

    fun score() = if (commonNumbers() == 0) 0 else 2.0.pow(commonNumbers() - 1).toInt()

    fun commonNumbers() = winningNumbers.intersect(numbersYouHave.toSet()).size
}