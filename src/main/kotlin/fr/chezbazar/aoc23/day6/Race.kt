package fr.chezbazar.aoc23.day6

data class Race(val time: Long, val distanceToBeat: Long) {
    fun winningWays(): Long {
        var minAccelerationTime = time
        var i = 1L
        while (i < time && i * (time - i) <= distanceToBeat) {
            i++
        }
        return if (i == time) {
            0
        } else {
            time - 2 * i + 1
        }
    }
}
