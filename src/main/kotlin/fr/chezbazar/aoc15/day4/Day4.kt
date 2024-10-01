package fr.chezbazar.aoc15.day4

import java.security.MessageDigest

const val PUZZLE_INPUT = "ckczppom"

fun main() {
    println(PUZZLE_INPUT.hashNumber())
    println(PUZZLE_INPUT.hashNumber(6))
}

fun String.hashNumber(leadingZeroes: Int = 5): Int {
    var current = 1
    while (!(this + current).md5().startsWith("0".repeat(leadingZeroes))) {
        current++
    }
    return current
}

@OptIn(ExperimentalStdlibApi::class)
fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return md.digest(this.toByteArray()).toHexString()
}