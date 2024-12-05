package fr.chezbazar.aoc15.day14

import fr.chezbazar.computeFrom

fun main() {
    val regex = Regex("\\w+ can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds.")
    val reindeers = mutableListOf<Reindeer>()
    computeFrom("aoc15/day14/input.txt") { line ->
        val (_, speed, flyTime, restTime) = regex.matchEntire(line)!!.groupValues.map { it.toIntOrNull() ?: 0 }
        reindeers.add(Reindeer(speed, flyTime, restTime))
    }
    println(reindeers.maxOf { it.distanceTraveled(2503) })
    reindeers.raceFor(2503)
    println(reindeers.maxOf { reindeer -> reindeer.points })
}

fun List<Reindeer>.raceFor(time: Int) {
    for (i in 1..time) {
        val winningDistance = this.maxOf { it.distanceTraveled(i) }
        this.filter { it.distanceTraveled(i) == winningDistance }.forEach { reindeer -> reindeer.awardPoint() }
    }
}