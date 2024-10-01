package fr.chezbazar.aoc23.day16

import fr.chezbazar.aoc23.Direction
import fr.chezbazar.aoc23.Point
import fr.chezbazar.computeFrom

fun main() {
    val input = mutableListOf<String>()
    computeFrom("aoc23/day16/input.txt") { line ->
        input.add(line)
    }
    Grid.from(input).apply {
        sendRay(Point(0,0), Direction.RIGHT)
        println(totalEnergized())
    }

    println((0 .. input.size).maxOf {
        Grid.from(input).run {
            sendRay(Point(0, it), Direction.RIGHT)
            totalEnergized()
        }
    })
    println((0 .. input.size).maxOf {
        Grid.from(input).run {
            sendRay(Point(input[0].lastIndex, it), Direction.LEFT)
            totalEnergized()
        }
    })
    println((0..input[0].length).maxOf {
        Grid.from(input).run {
            sendRay(Point(it, 0), Direction.DOWN)
            totalEnergized()
        }
    })
    println((0..input[0].length).maxOf {
        Grid.from(input).run {
            sendRay(Point(it, input.lastIndex), Direction.UP)
            totalEnergized()
        }
    })
}