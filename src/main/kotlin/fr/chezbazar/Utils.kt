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