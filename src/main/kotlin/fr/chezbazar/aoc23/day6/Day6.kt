package fr.chezbazar.aoc23.day6

import fr.chezbazar.aoc23.getBufferedReaderFrom

fun main() {
    val input = getBufferedReaderFrom("day6/input.txt")
    val times = input.readLine().split(":").last().trim().split(Regex("\\s+")).map { it.toLong() }
    val distances = input.readLine().split(":").last().trim().split(Regex("\\s+")).map { it.toLong() }
    val races = times.mapIndexed { index, time -> Race(time, distances[index]) }

    println(races.map { it.winningWays() }.reduce { acc, i -> acc * i })

    // Part 2
    val time = times.joinToString("") { it.toString() }.toLong()
    val distance = distances.joinToString("") { it.toString() }.toLong()
    val longRace = Race(time, distance)
    println(longRace)
    println(longRace.winningWays())
}