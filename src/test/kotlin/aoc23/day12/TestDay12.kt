package aoc23.day12

import fr.chezbazar.aoc23.day12.getCombination
import fr.chezbazar.aoc23.day12.getDataFromInputPart1
import fr.chezbazar.aoc23.day12.getDataFromInputPart2
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay12 {
    private val entries = listOf(
        "???.### 1,1,3",
        ".??..??...?##. 1,1,3",
        "?#?#?#?#?#?#?#? 1,3,1,6",
        "????.#...#... 4,1,1",
        "????.######..#####. 1,6,5",
        "?###???????? 3,2,1"
    )

    @Test
    fun testCombinations() = assertEquals(listOf(1L, 4L, 1L, 1L, 4L, 10L), entries.map { getDataFromInputPart1(it) }.map { (statusList, brokenPattern) -> getCombination(statusList, brokenPattern) })

    @Test
    fun testCombinationsPartTwo() = assertEquals(listOf(1L, 16384L, 1L, 16L, 2500L, 506250L), entries.map { getDataFromInputPart2(it) }.map { (statusList, brokenPattern) -> getCombination(statusList, brokenPattern) })
}