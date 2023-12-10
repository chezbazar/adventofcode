package aoc23.day10

import fr.chezbazar.aoc23.day10.Pipe
import fr.chezbazar.aoc23.day10.enclosedPoints
import fr.chezbazar.aoc23.day10.findLoop
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay10 {
    private val simpleLoop = listOf(
        ".....",
        ".S-7.",
        ".|.|.",
        ".L-J.",
        "....."
    ).map { line -> line.map { Pipe.from(it) }.toMutableList() }

    private val complexLoop = listOf(
        "...F7.",
        "..FJ|.",
        ".SJ.L7",
        ".|F--J",
        ".LJ..."
    ).map { line -> line.map { Pipe.from(it) }.toMutableList() }

    private  val bigLoop = listOf(
        "....................",
        "FF7FSF7F7F7F7F7F---7",
        "L|LJ||||||||||||F--J",
        "FL-7LJLJ||||||LJL-77",
        "F--JF--7||LJLJ7F7FJ-",
        "L---JF-JLJ.||-FJLJJ7",
        "|F|F-JF---7F7-L7L|7|",
        "|FFJF7L7F-JF7|JL---7",
        "7-L-JL7||F7|L7F-7F7|",
        "L.L7LFJ|||||FJL7||LJ",
        "L7JLJL-JLJLJL--JLJ.L"
    ).map { line -> line.map { Pipe.from(it) }.toMutableList() }

    @Test
    fun testLoop() {
        assertEquals(8, simpleLoop.findLoop().size)
        assertEquals(16, complexLoop.findLoop().size)
    }

    @Test
    fun testEnclosed() {
        val loop = bigLoop.findLoop()
        assertEquals(10, bigLoop.enclosedPoints(loop))
    }
}