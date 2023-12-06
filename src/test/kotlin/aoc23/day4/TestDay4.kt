package aoc23.day4

import fr.chezbazar.aoc23.day4.Card
import fr.chezbazar.aoc23.day4.play
import kotlin.test.Test
import kotlin.test.assertEquals

class TesDay4 {
    private val cards = listOf(
        Card.from("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"),
        Card.from("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19"),
        Card.from("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1"),
        Card.from("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83"),
        Card.from("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36"),
        Card.from("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11")
    )

    @Test
    fun testScore() = assertEquals(13, cards.sumOf { it.score() })

    @Test
    fun testTotalScratchcards() {
        cards.play()
        assertEquals(30, cards.sumOf { it.amount })
    }
}