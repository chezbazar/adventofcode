package fr.chezbazar.aoc23.day5

class Almanac(
    private val seedToSoilMapper: AlmanacMapper,
    private val soilToFertilizerMapper: AlmanacMapper,
    private val fertilizerToWaterMapper: AlmanacMapper,
    private val waterToLightMapper: AlmanacMapper,
    private val lightToTemperatureMapper: AlmanacMapper,
    private val temperatureToHumidityMapper: AlmanacMapper,
    private val humidityToLocationMapper: AlmanacMapper) {

    constructor(mappers: List<AlmanacMapper>) : this(mappers[0], mappers[1], mappers[2], mappers[3], mappers[4], mappers[5], mappers[6])

    fun seedToLocation(seed: Long) = globalMapper().map(seed)

    fun globalMapper() = seedToSoilMapper.mergeWith(soilToFertilizerMapper)
        .mergeWith(fertilizerToWaterMapper)
        .mergeWith(waterToLightMapper)
        .mergeWith(lightToTemperatureMapper)
        .mergeWith(temperatureToHumidityMapper)
        .mergeWith(humidityToLocationMapper)
}