package fr.chezbazar.aoc24.day5

class Printer {
    private val rules = mutableListOf<Pair<Int, Int>>()
    private val updates = mutableListOf<List<Int>>()

    fun configLine(line: String) {
        if (line.contains('|')) {
            val regex = Regex("(\\d+)\\|(\\d+)")
            val (_, first, second) = regex.matchEntire(line)!!.groupValues
            rules.add(first.toInt() to second.toInt())
        } else {
            updates.add(line.split(',').map { it.toInt() })
        }
    }

    private fun isValidUpdate(update: List<Int>): Boolean {
        for (i in 0..< update.lastIndex) {
            for (j in i + 1 .. update.lastIndex) {
                if (rules.contains(update[j] to update[i])) {
                    return false
                }
            }
        }
        return true
    }

    private fun updateScore(update: List<Int>) = if (isValidUpdate(update)) update[update.lastIndex / 2] else 0

    private fun orderUpdate(update: List<Int>): List<Int> {
        val comparator = Comparator<Int> { o1, o2 ->
            if (rules.contains(o1 to o2)) {
                -1
            } else if (rules.contains(o2 to o1)) {
                1
            } else {
                0
            }
        }
        return update.sortedWith(comparator)
    }

    fun score() = updates.sumOf { updateScore(it) }

    fun incorrectScore() = updates.filter { !isValidUpdate(it) }.map { orderUpdate(it) }.sumOf { updateScore(it) }
}