package fr.chezbazar.aoc23.day8

import fr.chezbazar.aoc23.computeFromIndexed

fun main() {
    var networkMap = NetworkMap("")
    computeFromIndexed("day8/input.txt") { index, line ->
        if (index == 0) {
            networkMap = NetworkMap(line)
        } else {
            networkMap.handleEntry(line)
        }
    }
    println(networkMap.getSteps())
    println(networkMap.getGhostSteps())
}