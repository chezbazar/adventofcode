package fr.chezbazar.aoc15.day11

const val INITIAL_PASSWORD = "cqjxjnds"

fun main() {
    println(INITIAL_PASSWORD.nextValidPassword())
    println(INITIAL_PASSWORD.nextValidPassword().nextValidPassword())
}

private fun String.nextPassword(): String = if (last() != 'z') {
    substring(0 until lastIndex) + (last().inc())
} else {
    substring(0 until lastIndex).nextPassword() + 'a'
}

private fun String.hasThreeIncreasingLetters() = windowed(3).any { it[1] == it[0].inc() && it[2] == it[1].inc() }

private fun String.hasOnlyValidLetters() = none { arrayOf('i', 'o', 'l').contains(it) }

private fun String.hasTwoTwins() = windowed(2).filter { it[0] == it[1] }.toSet().size >= 2

private fun String.isValidPassword() = hasOnlyValidLetters() && hasThreeIncreasingLetters() && hasTwoTwins()

fun String.nextValidPassword(): String {
    var currentPassword = nextPassword()
    while (!currentPassword.isValidPassword()) {
        currentPassword = currentPassword.nextPassword()
    }
    return currentPassword
}