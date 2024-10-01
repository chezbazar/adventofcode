package fr.chezbazar.aoc15.day10

const val INPUT = "3113322113"

fun main() {
    var sequence = INPUT
    repeat(40) {
        sequence = sequence.lookAndSay()
    }
    println(sequence.length)
    repeat(10) {
        sequence = sequence.lookAndSay()
    }
    println(sequence.length)
}

fun String.lookAndSay() : String {
    val decomposedString = mutableListOf<String>()
    var currentChar = this[0]
    var currentString = ""
    forEach { c ->
        if (c == currentChar) {
            currentString += c
        } else {
            decomposedString.add(currentString)
            currentChar = c
            currentString = c.toString()
        }
    }
    decomposedString.add(currentString)
    return decomposedString.joinToString("") { "${it.length}${it[0]}" }
}