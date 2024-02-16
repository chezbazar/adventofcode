package fr.chezbazar.aoc23.day14

import fr.chezbazar.aoc23.computeFrom
import fr.chezbazar.aoc23.inverted

fun main() {
    val rockMap = mutableListOf<String>()
    computeFrom("day14/input.txt") {
        rockMap.add(it)
    }
    println(rockMap.inverted().sumOf { it.roll().rockLoad() })
    println(rockMap.performCycles(1_000_000_000).inverted().sumOf { it.rockLoad() })
}

fun String.roll() = this.split("#").joinToString("#") { s -> String(s.toCharArray().sortedArrayDescending()) }

fun String.rockLoad() = this.mapIndexed { index, c -> if (c == 'O') this.length - index else 0 }.sum()

fun List<String>.rollNorth() = this.inverted().map { it.roll() }.inverted()
fun List<String>.rollSouth() = this.inverted().map { it.reversed().roll().reversed() }.inverted()
fun List<String>.rollWest() = this.map { it.roll() }
fun List<String>.rollEast() = this.map { it.reversed().roll().reversed() }

fun List<String>.performCycle() = this.rollNorth().rollWest().rollSouth().rollEast()

fun List<String>.performCycles(amount: Int): List<String> {
    val statusList = mutableListOf(this)
    var i = 1
    var workMap = this.performCycle()
    while (i < amount && !statusList.contains(workMap)) {
        statusList.add(workMap)
        i++
        workMap = workMap.performCycle()
    }
    if (i < amount) {
        val loopList = statusList.subList(statusList.indexOf(workMap), statusList.size)
        workMap = loopList[(amount - i) % loopList.size]
    }
    return workMap
}