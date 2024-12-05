package fr.chezbazar.aoc15.day14

import kotlin.math.min

class Reindeer(private val speed: Int, private val flyTime: Int, private val restTime: Int) {
    var points = 0
    fun distanceTraveled(time:Int) = speed * (flyTime * (time / (flyTime + restTime)) + min(flyTime, time % (flyTime + restTime)))
    fun awardPoint() = points++
}