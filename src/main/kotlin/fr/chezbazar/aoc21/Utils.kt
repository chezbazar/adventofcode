package fr.chezbazar.aoc21

import java.io.File

fun getBufferedReaderFrom(path: String) = File("src/main/resources/aoc21/$path").bufferedReader()

fun computeFrom(path: String, action: (line: String) -> Unit) = getBufferedReaderFrom(path).forEachLine { line ->
    if (line.isNotEmpty()) {
        action(line)
    }
}