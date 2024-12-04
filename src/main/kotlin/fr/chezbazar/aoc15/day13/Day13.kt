package fr.chezbazar.aoc15.day13

import fr.chezbazar.computeFrom
import fr.chezbazar.permutations

fun main() {
    val regex = Regex("(\\w*) would (gain|lose) (\\d*) happiness units by sitting next to (\\w*).")
    computeFrom("aoc15/day13/input.txt") { line ->
        val (_, attendee, type, amount, otherAttendee) = regex.matchEntire(line)!!.groupValues
        val intAmount = if (type == "lose") {
            amount.toInt() * -1
        } else {
            amount.toInt()
        }
        Attendee.get(attendee).setHappinessFrom(Attendee.get(otherAttendee), intAmount)
    }
    println(Attendee.all().optimalHappiness())
    Attendee.addMyself()
    println(Attendee.all().optimalHappiness())
}