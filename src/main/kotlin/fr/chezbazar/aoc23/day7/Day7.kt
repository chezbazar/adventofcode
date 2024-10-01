package fr.chezbazar.aoc23.day7

import fr.chezbazar.computeFrom

fun main() {
    val hands = mutableListOf<Hand>()
    val jokerHands = mutableListOf<HandJoker>()
    computeFrom("aoc23/day7/input.txt") {
        hands.add(Hand.from(it))
        jokerHands.add(HandJoker.from(it))
    }
    println(hands.sorted().mapIndexed { index, hand -> (index + 1) * hand.bidding }.sum())
    println(jokerHands.sorted().mapIndexed { index, hand -> (index + 1) * hand.bidding }.sum())
}