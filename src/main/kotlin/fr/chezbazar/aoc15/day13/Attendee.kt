package fr.chezbazar.aoc15.day13

import fr.chezbazar.permutations

class Attendee {
    companion object {
        private val attendees = mutableMapOf<String, Attendee>()

        fun get(name: String) = attendees.getOrPut(name) { Attendee() }

        fun all() = attendees.values.toList()

        fun addMyself() = all().forEach { attendee ->
            get("self").setHappinessFrom(attendee, 0)
            attendee.setHappinessFrom(get("self"), 0)
        }
    }

    private val happinessMap = mutableMapOf<Attendee, Int>()

    fun setHappinessFrom(attendee: Attendee, value: Int) {
        happinessMap[attendee] = value
    }

    fun getHappinessFrom(attendee: Attendee) = happinessMap[attendee] ?: 0
}

fun List<Attendee>.happinessMap() = this.mapIndexed { index, attendee ->
    attendee.getHappinessFrom(this[(index + 1).mod(this.size)]) + attendee.getHappinessFrom(this[(index - 1).mod(this.size)])
}

fun List<Attendee>.optimalHappiness() = this.permutations().maxOfOrNull { it.happinessMap().sum() } ?: Int.MIN_VALUE