package fr.chezbazar.aoc15.day12

import kotlinx.serialization.json.*
import java.io.File

fun main() {
    val input = Json.parseToJsonElement(File("src/main/resources/aoc15/day12/input.txt").readText())
    println(input.sumOfNumbers())
    println(input.sumOfNumbers(true))
}

fun JsonElement.sumOfNumbers(excludeRed: Boolean = false): Int {
    return when(this) {
        is JsonObject -> if (excludeRed && jsonObject.containsValue(JsonPrimitive("red"))) 0 else values.sumOf { it.sumOfNumbers(excludeRed) }
        is JsonArray -> jsonArray.sumOf { it.sumOfNumbers(excludeRed) }
        is JsonPrimitive -> jsonPrimitive.content.toIntOrNull() ?: 0
    }
}