package fr.chezbazar.aoc23.day5

class AlmanacMapper(private val instructions: List<Instruction>) {
    fun map(input: Long): Long {
        instructions.forEach { (range, diff) ->
            if (range.contains(input)) {
                return input + diff
            }
        }
        return input
    }

    fun minDestination(interval: LongRange) = instructions.minOf { instruction ->
        val intersection = instruction.sourceRange.intersect(interval)
        if (!intersection.isEmpty()) {
            map(intersection.first)
        } else {
            Long.MAX_VALUE
        }
    }

    fun fullInstructions(): List<Instruction> {

        val currentInstructions = instructions.toMutableList()
        if (instructions.minOf { it.sourceRange.first } != 0L) {
            currentInstructions.add(Instruction(0L ..< instructions.minOf { it.sourceRange.first }, 0))
        }
        if (instructions.maxOf { it.sourceRange.last } != Long.MAX_VALUE) {
            currentInstructions.add(Instruction(instructions.maxOf { it.sourceRange.last } + 1 .. Long.MAX_VALUE, 0))
        }
        currentInstructions.sortBy { it.sourceRange.first }
        val instructionsToAdd = mutableListOf<Instruction>()
        for (i in 1..currentInstructions.lastIndex) {
            if (currentInstructions[i].sourceRange.first > currentInstructions[i-1].sourceRange.last + 1) {
                instructionsToAdd.add(Instruction(
                    currentInstructions[i-1].sourceRange.last + 1 ..< currentInstructions[i].sourceRange.first, 0))
            }
        }
        currentInstructions.addAll(instructionsToAdd)
        return currentInstructions.sortedBy { it.sourceRange.first }
    }

    fun mergeWith(successor: AlmanacMapper): AlmanacMapper {
        val currentInstructions = fullInstructions()
        val successorInstructions = successor.fullInstructions()
        val instructions = mutableListOf<Instruction>()
        currentInstructions.forEach { instruction ->
            val destinationRange = instruction.getDestinationRange()
            successorInstructions.forEach { successorInstruction ->
                val intersection = destinationRange.intersect(successorInstruction.sourceRange)
                if (!intersection.isEmpty()) {
                    instructions.add(
                        Instruction(
                        intersection.first - instruction.offset .. intersection.last - instruction.offset,
                        instruction.offset + successorInstruction.offset)
                    )
                }
            }
        }
        return AlmanacMapper(instructions.sortedBy { it.sourceRange.first })
    }

    private fun LongRange.intersect(other: LongRange) = maxOf(this.first, other.first) .. minOf(this.last, other.last)
}