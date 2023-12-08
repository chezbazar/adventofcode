package aoc23.day5

import fr.chezbazar.aoc23.day5.Almanac
import fr.chezbazar.aoc23.day5.AlmanacMapper
import fr.chezbazar.aoc23.day5.Instruction
import fr.chezbazar.aoc23.day5.toInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay5 {
    private val seeds = listOf(79L, 14L, 55L, 13L)

    private val seedToSoilMapper = AlmanacMapper(listOf(
        "50 98 2",
        "52 50 48"
    ).map { it.toInstruction() })
    private val soilToFertilizerMapper = AlmanacMapper(listOf(
        "0 15 37",
        "37 52 2",
        "39 0 15"
    ).map { it.toInstruction() })
    private val fertilizerToWaterMapper = AlmanacMapper(listOf(
        "49 53 8",
        "0 11 42",
        "42 0 7",
        "57 7 4"
    ).map { it.toInstruction() })
    private val waterToLightMapper = AlmanacMapper(listOf(
        "88 18 7",
        "18 25 70"
    ).map { it.toInstruction() })
    private val lightToTemperatureMapper = AlmanacMapper(listOf(
        "45 77 23",
        "81 45 19",
        "68 64 13"
    ).map { it.toInstruction() })
    private val temperatureToHumidityMapper = AlmanacMapper(listOf(
        "0 69 1",
        "1 0 69"
    ).map { it.toInstruction() })
    private val humidityToLocationMapper = AlmanacMapper(listOf(
        "60 56 37",
        "56 93 4"
    ).map { it.toInstruction() })

    private val intervals = listOf(79L..<79L + 14L, 55L..<55L + 13L)

    private val almanac = Almanac(seedToSoilMapper, soilToFertilizerMapper, fertilizerToWaterMapper, waterToLightMapper, lightToTemperatureMapper, temperatureToHumidityMapper, humidityToLocationMapper)

    @Test
    fun testLocation() = assertEquals(listOf(82L, 43L, 86L, 35L), seeds.map { almanac.seedToLocation(it) })

    @Test
    fun testDestinationRange() = assertEquals(10L .. 15L, Instruction(5L..10L, 5).getDestinationRange())

    @Test
    fun testFullInstructions() = assertEquals(
        listOf(
            Instruction(0..10L, 0),
            Instruction(11L..20L, 2),
            Instruction(21L .. 30L, 0),
            Instruction(31L..40L, 3),
            Instruction(41L .. Long.MAX_VALUE,0)
        ),
        AlmanacMapper(listOf(Instruction(31L..40L, 3), Instruction(11L..20L, 2))).fullInstructions()
    )

    @Test
    fun testMergeMappers() {
        val firstMapper = AlmanacMapper(listOf(Instruction(10L .. 20L, 5), Instruction(30L..40L, -10)))
        val secondMapper = AlmanacMapper(listOf(Instruction(7L..17L, 7), Instruction(23L..27L, 14)))
        val expectedMapper = AlmanacMapper(listOf(
            Instruction(0L..6L, 0),
            Instruction(7L..9L, 7),
            Instruction(10L..12L, 12),
            Instruction(13L..17L, 5),
            Instruction(18L..20L, 19),
            Instruction(21L..22L, 0),
            Instruction(23L..27L, 14),
            Instruction(28L..29L, 0),
            Instruction(30L.. 32L, -10),
            Instruction(33L..37L, 4),
            Instruction(38L..40L, -10),
            Instruction(41L..Long.MAX_VALUE, 0)
        ))
        assertEquals(expectedMapper.fullInstructions(), firstMapper.mergeWith(secondMapper).fullInstructions())
    }

    @Test
    fun testIntervals() = assertEquals(46L, intervals.minOf { interval -> almanac.globalMapper().minDestination(interval) })
}