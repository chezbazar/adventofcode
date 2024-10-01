package fr.chezbazar.aoc15.day7

import fr.chezbazar.getBufferedReaderFrom

fun main() {
    val assembly = Assembly()
    val instructions = getBufferedReaderFrom("aoc15/day7/input.txt").readLines()
    assembly.playInstructions(instructions)
    println(assembly.state["a"])
    println(assembly.state["b"])
    val reassembly = Assembly()
    reassembly.handleInstruction("${assembly.state["a"]} -> b")
    reassembly.playInstructions(instructions, "b")
    println(reassembly.state["a"])
    println(reassembly.state["b"])
}

fun Assembly.playInstructions(instructions: List<String>, wireToIgnore: String = "") {
    var instructionsToPlay = instructions
    while (instructionsToPlay.isNotEmpty()) {
        val instructionsToReplay = mutableListOf<String>()
        instructionsToPlay.forEach {
            try {
                this.handleInstruction(it, wireToIgnore)
            } catch (e: ParseValueException) {
//                println(e.message)
//                println("Will replay instruction later : $it")
                instructionsToReplay.add(it)
            }
        }
        instructionsToPlay = instructionsToReplay
    }
}