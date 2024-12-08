package fr.chezbazar

import java.io.File

fun getBufferedReaderFrom(path: String) = File("src/main/resources/$path").bufferedReader()

fun computeFrom(path: String, action: (line: String) -> Unit) = getBufferedReaderFrom(path).forEachLine { line ->
    if (line.isNotEmpty()) {
        action(line)
    }
}

fun computeFromIndexed(path: String, action: (index: Int, line: String) -> Unit) {
    var index = 0
    getBufferedReaderFrom(path).forEachLine { line ->
        if (line.isNotEmpty()) {
            action(index, line)
        }
        index++
    }
}

fun List<String>.inverted() = List(this[0].length) { index -> this.map { it[index] } }.map { String(it.toCharArray()) }

fun <T> List<T>.permutations(): List<List<T>> {
    val result = mutableListOf<List<T>>()
    if (this.size == 1) {
        result.add(this)
    } else if (this.size > 1) {
        this.forEachIndexed { index, item ->
            this.withoutElementAt(index).permutations().forEach { permutation ->
                val listToAdd = mutableListOf(item)
                listToAdd.addAll(permutation)
                result.add(listToAdd)
            }
        }
    }
    return result
}

fun <T> Iterable<T>.withoutElementAt(index: Int) = this.filterIndexed { i, _ -> index != i }

fun List<String>.lines() = this

fun List<String>.columns() = List(this.maxOf { it.length }) { index ->
    this.joinToString("") {
        if (it.indices.contains(index)) {
            it[index].toString()
        } else ""
    }
}

fun List<String>.diagonalsRight(): List<String> {
    val result = mutableListOf<String>()
    if (this.isEmpty()) {
        return result
    }
    for (j in this[0].lastIndex downTo 0) {
        var newVal = ""
        for (i in 0..(this[0].lastIndex - j)) {
            newVal += this[i][j + i]
        }
        result.add(newVal)
    }
    for (i in 1..this.lastIndex) {
        var newVal = ""
        for (j in 0..(this.lastIndex - i)) {
            newVal += this[i+j][j]
        }
        result.add(newVal)
    }
    return result
}

fun List<String>.diagonalsLeft() = this.map { it.reversed() }.diagonalsRight()

fun String.countOccurrencesOf(substring: String): Int {
    var result = 0
    for (i in 0..this.length - substring.length) {
        if (this.substring(i until i + substring.length) == substring) result++
    }
    return result
}

fun <T> List<T>.pairs(): List<Pair<T, T>> = flatMapIndexed { index, el -> if (index == lastIndex) listOf() else subList(index + 1, size).map { el to it } }