package fr.chezbazar.aoc15.day9

import fr.chezbazar.getBufferedReaderFrom

fun main() {
    val input = getBufferedReaderFrom("aoc15/day9/input.txt").readLines()
    val (cities, distances) = extractData(input)
    println(cities.combinations().minOf { it.pathDistance(distances) })
    println(cities.combinations().maxOf { it.pathDistance(distances) })
}

fun Set<String>.combinations() : List<List<String>> {
    val combinations = mutableListOf<List<String>>()
    if (size == 1) {
        return listOf(listOf(first()))
    } else {
        this.forEach { element ->
            minusElement(element).combinations().forEach { combinations.add(listOf(element, *it.toTypedArray())) }
        }
        return combinations
    }
}

fun extractData(entries: List<String>) : Pair<Set<String>, Map<Pair<String, String>, Int>> {
    val cities = mutableSetOf<String>()
    val distances = mutableMapOf<Pair<String, String>, Int>()
    val regex = Regex("(\\w+) to (\\w+) = (\\d+)")
    entries.forEach {
        val (_, city1, city2, distance) = regex.matchEntire(it)!!.groupValues
        cities.add(city1)
        cities.add(city2)
        distances[city1 to city2] = distance.toInt()
        distances[city2 to city1] = distance.toInt()
    }
    return cities to distances
}

fun List<String>.pathDistance(distances: Map<Pair<String, String>, Int>) = subList(0, lastIndex).mapIndexed { index, s -> distances[s to this[index + 1]]!! }.sum()