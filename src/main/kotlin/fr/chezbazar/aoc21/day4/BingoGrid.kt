package fr.chezbazar.aoc21.day4

class BingoGrid private constructor(val grid: List<List<Box>>) {
    data class Box(val value: Int, var ticked: Boolean = false)

    companion object {
        fun from(grid: List<List<Int>>) = BingoGrid(grid.map { it.map { value -> Box(value) } })
    }

    private var hasWon = false

    fun tick(number: Int): Boolean {
        if (!hasWon) {
            grid.forEachIndexed { i, boxes ->
                boxes.forEachIndexed { j, box ->
                    if (box.value == number) {
                        box.ticked = true
                        hasWon = (grid[i].all { it.ticked } || grid.map { it[j] }.all { it.ticked })
                        return hasWon
                    }
                }
            }
        }
        return false
    }

    fun unmarked() = grid.sumOf { it.filter { box -> !box.ticked }.sumOf { box -> box.value } }
}