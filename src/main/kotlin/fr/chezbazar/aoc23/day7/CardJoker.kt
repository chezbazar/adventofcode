package fr.chezbazar.aoc23.day7

enum class CardJoker(val symbol: Char) {
    JOKER('J'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    companion object {
        fun from(symbol: Char) = entries.first { it.symbol == symbol }
    }
}