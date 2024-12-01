package fr.chezbazar.aoc24.day1

import fr.chezbazar.computeFrom
import kotlin.math.abs

fun main() {
    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()
    computeFrom("aoc24/day1/input.txt") {
        val  (firstVal, secondVal) = it.split("   ")
        firstList.add(firstVal.toInt())
        secondList.add(secondVal.toInt())
    }
    println(distance(firstList, secondList))
    println(similarity(firstList, secondList))
}

fun distance(firstList: List<Int>, secondList: List<Int>): Int {
    val sortedFirstList = firstList.sorted()
    val sortedSecondList = secondList.sorted()
    val distanceList = List(sortedFirstList.size) { index -> abs(sortedFirstList[index] - sortedSecondList[index]) }
    return distanceList.sum()
}

fun similarity(firstList: List<Int>, secondList: List<Int>) = List(firstList.size) { index -> firstList[index] * secondList.count { value -> value == firstList[index] } }.sum()