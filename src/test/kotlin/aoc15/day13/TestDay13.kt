package aoc15.day13

import fr.chezbazar.aoc15.day13.Attendee
import fr.chezbazar.aoc15.day13.optimalHappiness
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay13 {
    private val attendees = mutableListOf<Attendee>()

    @BeforeTest
    fun setup() {
        val alice = Attendee.get("Alice")
        val bob = Attendee.get("Bob")
        val carol = Attendee.get("Carol")
        val david = Attendee.get("David")
        alice.run {
            setHappinessFrom(bob, 54)
            setHappinessFrom(carol, -79)
            setHappinessFrom(david, -2)
        }
        bob.run {
            setHappinessFrom(alice, 83)
            setHappinessFrom(carol, -7)
            setHappinessFrom(david, -63)
        }
        carol.run {
            setHappinessFrom(alice, -62)
            setHappinessFrom(bob, 60)
            setHappinessFrom(david, 55)
        }
        david.run {
            setHappinessFrom(alice, 46)
            setHappinessFrom(bob, -7)
            setHappinessFrom(carol, 41)
        }
        attendees.addAll(listOf(alice, bob, carol, david))
    }

    @Test
    fun testHappiness() {
        assertEquals(330, attendees.optimalHappiness())
    }
}