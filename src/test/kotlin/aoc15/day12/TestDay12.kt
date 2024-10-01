package aoc15.day12

import fr.chezbazar.aoc15.day12.sumOfNumbers
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay12 {
    @Test
    fun testSumOfNumbers() {
        assertEquals(6, Json.parseToJsonElement("[1,2,3]").sumOfNumbers())
        assertEquals(6, Json.parseToJsonElement("{\"a\":2,\"b\":4}").sumOfNumbers())
        assertEquals(3, Json.parseToJsonElement("[[[3]]]").sumOfNumbers())
        assertEquals(3, Json.parseToJsonElement("{\"a\":{\"b\":4},\"c\":-1}").sumOfNumbers())
        assertEquals(0, Json.parseToJsonElement("{\"a\":[-1,1]}").sumOfNumbers())
        assertEquals(0, Json.parseToJsonElement("[-1,{\"a\":1}]").sumOfNumbers())
        assertEquals(0, Json.parseToJsonElement("[]").sumOfNumbers())
        assertEquals(0, Json.parseToJsonElement("{}").sumOfNumbers())
    }

    @Test
    fun testRedExclusion() {
        assertEquals(6, Json.parseToJsonElement("[1,2,3]").sumOfNumbers(true))
        assertEquals(4, Json.parseToJsonElement("[1,{\"c\":\"red\",\"b\":2},3]").sumOfNumbers(true))
        assertEquals(0, Json.parseToJsonElement("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}").sumOfNumbers(true))
        assertEquals(6, Json.parseToJsonElement("[1,\"red\",5]").sumOfNumbers(true))
    }
}