package fr.chezbazar.aoc23.day5

import fr.chezbazar.computeFrom

fun main() {
    val seeds = mutableListOf<Long>()
    val almanacMappers = mutableListOf<AlmanacMapper>()
    val currentMappers = mutableListOf<Instruction>()
    computeFrom("aoc23/day5/input.txt") { entry ->
        when {
            entry.startsWith("seeds") -> entry.split(":").last().trim().split(" ").forEach { seeds.add(it.toLong()) }
            entry[0].isDigit() -> currentMappers.add(entry.toInstruction())
            currentMappers.isNotEmpty() -> {
                almanacMappers.add(AlmanacMapper(currentMappers.toList()))
                currentMappers.clear()
            }
        }
    }
    if (currentMappers.isNotEmpty()) {
        almanacMappers.add(AlmanacMapper(currentMappers.toList()))
    }
    val almanac = Almanac(almanacMappers)
    println(seeds.minOf { almanac.seedToLocation(it) })
    val intervals = seeds.chunked(2).map { (start, size) -> start..<start + size }
    println(intervals.minOf { almanac.globalMapper().minDestination(it) })
}

fun String.toInstruction() : Instruction {
    val (destination, source, size) = split(" ").map { it.toLong() }
    return Instruction(source ..< source + size, destination - source)
}