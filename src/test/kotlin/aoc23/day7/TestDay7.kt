package aoc23.day7

import fr.chezbazar.aoc23.day7.Hand
import fr.chezbazar.aoc23.day7.HandJoker
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay7 {
    private val entries = listOf("32T3K 765", "T55J5 684", "KK677 28", "KTJJT 220", "QQQJA 483")
    private val hands = entries.map { Hand.from(it) }
    private val jokerHands = entries.map { HandJoker.from(it) }

    @Test
    fun testPart1() = assertEquals(6440, hands.sorted().mapIndexed { index, hand -> (index + 1) * hand.bidding }.sum())

    @Test
    fun testPart2() = assertEquals(5905, jokerHands.sorted().mapIndexed { index, hand -> (index + 1) * hand.bidding }.sum())
}