package fr.chezbazar.aoc23.day2

class Round(val red: Int, val green: Int, val blue: Int) {
    companion object {
        fun from(text: String): Round {
            val balls = text.split(",")
            var (red, green, blue) = listOf(0,0,0)
            balls.forEach {
                val (amount, color) = it.trim().split(" ")
                when (color) {
                    "red" -> red = amount.toInt()
                    "green" -> green = amount.toInt()
                    "blue" -> blue = amount.toInt()
                }
            }
            return Round(red, green, blue)
        }
    }

    fun isPossible(maxRed: Int, maxGreen: Int, maxBlue: Int) = red <= maxRed && green <= maxGreen && blue <= maxBlue
}