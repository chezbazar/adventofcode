package fr.chezbazar.aoc23.day4

import fr.chezbazar.aoc23.computeFrom

fun main() {
    val cards = mutableListOf<Card>()
    computeFrom("day4/input.txt") {
        cards.add(Card.from(it))
    }
    println(cards.sumOf { it.score() })
    cards.play()
    println(cards.sumOf { it.amount })
}

fun List<Card>.play() = this.forEachIndexed { index, card ->
    for (i in index + 1 .. minOf(index + card.commonNumbers(), this.lastIndex)) {
        this[i].amount += card.amount
    }
}