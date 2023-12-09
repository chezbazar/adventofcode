package fr.chezbazar.aoc23.day7

class Hand(private val cards: List<Card>, val bidding: Int): Comparable<Hand> {

    companion object {
        fun from(entry: String): Hand {
            val (cards, bidding) = entry.split(" ")
            return Hand(cards.map { Card.from(it) }, bidding.toInt())
        }
    }

    private fun type(): HandType {
        val cardsMap = mutableMapOf<Card, Int>()
        cards.forEach {
            cardsMap[it] = cardsMap.getOrDefault(it, 0) + 1
        }
        val amounts = cardsMap.values.sortedDescending()
        return if (amounts.first() == 5) {
            HandType.FIVE
        } else if (amounts.first() == 4) {
            HandType.FOUR
        } else if (amounts.first() == 3 && amounts[1] == 2) {
            HandType.FULL
        } else if (amounts.first() == 3) {
            HandType.THREE
        } else if (amounts.first() == 2 && amounts[1] == 2) {
            HandType.TWOPAIRS
        } else if (amounts.first() == 2) {
            HandType.ONEPAIR
        } else {
            HandType.HIGH
        }
    }

    override fun compareTo(other: Hand): Int {
        return if (type() != other.type()) {
            type().compareTo(other.type())
        } else {
            val comparisons = cards.mapIndexed { index, card -> card.compareTo(other.cards[index]) }
            comparisons.firstOrNull { it != 0 } ?: 0
        }
    }
}