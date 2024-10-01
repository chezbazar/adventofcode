package fr.chezbazar.aoc23.day15

import fr.chezbazar.computeFrom

fun main() {
    computeFrom("aoc23/day15/input.txt") { line ->
        println(line.split(",").sumOf { it.hash() })
        println(line.focusingPower().mapIndexed { index, map -> (index + 1) * map.focusingPower() }.sum())
    }
}

fun String.hash() : Int {
    var currentValue = 0
    this.forEach {
        currentValue = ((currentValue + it.code) * 17) % 256
    }
    return currentValue
}

fun String.focusingPower() : List<Map<String, Int>> {
    val boxes = List(256) { mutableMapOf<String, Int>() }
    val instructions = this.split(",").map { Instruction.from(it) }
    instructions.forEach { (label, operation, amount) ->
        when (operation) {
            '-' -> boxes[label.hash()].remove(label)
            else -> boxes[label.hash()][label] = amount!!
        }
    }
    return boxes
}

fun Map<String, Int>.focusingPower() = this.asSequence().mapIndexed { index, (_, value) -> (index + 1) * value }.sum()