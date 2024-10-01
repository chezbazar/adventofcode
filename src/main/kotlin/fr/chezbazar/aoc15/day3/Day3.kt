package fr.chezbazar.aoc15.day3

import fr.chezbazar.aoc15.Point
import fr.chezbazar.computeFrom

fun main() {
    computeFrom("aoc15/day3/input.txt") {
        println(getHousesSetFrom(it).size)
        val (santaPath, robotSantaPath) = it.distribute()
        println(getHousesSetFrom(santaPath).union(getHousesSetFrom(robotSantaPath)).size)
    }
}

fun getHousesSetFrom(path: String): Set<Point> {
    val allHouses = mutableSetOf(Point(0,0))
    var currentHouse = Point(0,0)
    path.forEach { direction ->
        currentHouse = when(direction) {
            '^' -> currentHouse.moveUp()
            'v' -> currentHouse.moveDown()
            '<' -> currentHouse.moveLeft()
            else -> currentHouse.moveRight()
        }
        allHouses.add(currentHouse)
    }
    return allHouses
}

fun String.distribute() = this.filterIndexed { index, _ -> index % 2 == 0 } to this.filterIndexed { index, _ -> index % 2 == 1 }