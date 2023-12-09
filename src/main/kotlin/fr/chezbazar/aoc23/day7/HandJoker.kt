package fr.chezbazar.aoc23.day7

class HandJoker(private val cards: List<CardJoker>, val bidding: Int): Comparable<HandJoker> {

    companion object {
        fun from(entry: String): HandJoker {
            val (cards, bidding) = entry.split(" ")
            return HandJoker(cards.map { CardJoker.from(it) }, bidding.toInt())
        }
    }

    private fun type(): HandType {
        val cardsMap = mutableMapOf<CardJoker, Int>()
        var jokers = 0
        cards.forEach {
            if (it != CardJoker.JOKER) {
                cardsMap[it] = cardsMap.getOrDefault(it, 0) + 1
            } else {
                jokers++
            }
        }
        val amounts = cardsMap.values.sortedDescending()
        return if (((amounts.firstOrNull() ?: 0) + jokers) == 5) {
            HandType.FIVE
        } else if (amounts.first() + jokers == 4) {
            HandType.FOUR
        } else if (amounts.first() + jokers == 3 && amounts[1] == 2) {
            HandType.FULL
        } else if (amounts.first() + jokers == 3) {
            HandType.THREE
        } else if (amounts.first() + jokers == 2 && amounts[1] == 2) {
            HandType.TWOPAIRS
        } else if (amounts.first() + jokers == 2) {
            HandType.ONEPAIR
        } else {
            HandType.HIGH
        }
    }

    override fun compareTo(other: HandJoker): Int {
        return if (type() != other.type()) {
            type().compareTo(other.type())
        } else {
            val comparisons = cards.mapIndexed { index, card -> card.compareTo(other.cards[index]) }
            comparisons.firstOrNull { it != 0 } ?: 0
        }
    }
}