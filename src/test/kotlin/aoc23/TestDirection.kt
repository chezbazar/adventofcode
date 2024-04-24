package aoc23

import fr.chezbazar.aoc23.Direction
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDirection {
    @Test
    fun testTurnRight() {
        assertEquals(Direction.RIGHT, Direction.UP.turnRight())
        assertEquals(Direction.DOWN, Direction.RIGHT.turnRight())
        assertEquals(Direction.LEFT, Direction.DOWN.turnRight())
        assertEquals(Direction.UP, Direction.LEFT.turnRight())
    }

    @Test
    fun testTurnLeft() {
        assertEquals(Direction.LEFT, Direction.UP.turnLeft())
        assertEquals(Direction.DOWN, Direction.LEFT.turnLeft())
        assertEquals(Direction.RIGHT, Direction.DOWN.turnLeft())
        assertEquals(Direction.UP, Direction.RIGHT.turnLeft())
    }
}