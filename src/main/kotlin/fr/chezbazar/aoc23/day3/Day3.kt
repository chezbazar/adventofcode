package fr.chezbazar.aoc23.day3

import fr.chezbazar.aoc23.Point
import fr.chezbazar.aoc23.RectangularRange
import fr.chezbazar.aoc23.getBufferedReaderFrom
import java.util.stream.Collectors

fun main() {
    val input = getBufferedReaderFrom("day3/input.txt").lines().collect(Collectors.toList())
    val (numbers, symbols) = input.getData()
    println(numbers.filter { number -> symbols.any { number.isAdjacentTo(it) } }.sumOf { it.number })
    println(symbols.filter { it.isGear() }.sumOf { gear ->
        val adjacentNumbers = numbers.filter { it.isAdjacentTo(gear) }
        if (adjacentNumbers.size == 2) {
            adjacentNumbers.first().number * adjacentNumbers.last().number
        } else {
            0
        }
    })
}

fun List<String>.getData() : Pair<List<Number>, List<Symbol>> {
    val numbers = mutableListOf<Number>()
    val symbols = mutableListOf<Symbol>()
    var currentNumber=""
    var isInNumber = false
    var xMin = 0
    this.forEachIndexed { y, line ->
        line.forEachIndexed { x, c ->
            if (c.isDigit()) {
                currentNumber += c
                if (!isInNumber) {
                    xMin = x
                    isInNumber = true
                }
                if (x == line.lastIndex) {
                    numbers.add(Number(currentNumber.toInt(), RectangularRange(xMin..x, y..y)))
                    currentNumber = ""
                    isInNumber = false
                }
            } else {
                if (isInNumber) {
                    isInNumber = false
                    numbers.add(Number(currentNumber.toInt(), RectangularRange(xMin..x-1, y..y)))
                    currentNumber = ""
                }
                if (c != '.') {
                    symbols.add(Symbol(c, Point(x, y)))
                }
            }
        }
    }
    return numbers to symbols
}