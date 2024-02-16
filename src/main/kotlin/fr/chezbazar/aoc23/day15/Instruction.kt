package fr.chezbazar.aoc23.day15

data class Instruction(val label: String, val operation: Char, val value: Int? = null) {
    companion object {
        fun from(s: String) = if (s.contains('-')) {
            Instruction(s.dropLast(1), '-')
        } else {
            val (label, amount) = s.split("=")
            Instruction(label, '=', amount.toInt())
        }
    }
}
