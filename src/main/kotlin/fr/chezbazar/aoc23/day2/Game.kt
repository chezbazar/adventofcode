package fr.chezbazar.aoc23.day2

class Game(val id: Int, val rounds: List<Round>) {
    companion object {
        fun from(text: String): Game {
            val regex = Regex("Game (\\d+): (.*)")
            val (id, roundsDescription) = regex.find(text)!!.destructured
            val rounds = mutableListOf<Round>()
            roundsDescription.split(";").forEach { rounds.add(Round.from(it)) }
            return Game(id.toInt(), rounds)
        }
    }

    fun isPossible(maxRed: Int, maxGreen: Int, maxBlue: Int) = rounds.all { it.isPossible(maxRed, maxGreen, maxBlue) }

    fun power() = rounds.maxOf { it.red } * rounds.maxOf { it.green } * rounds.maxOf { it.blue }
}