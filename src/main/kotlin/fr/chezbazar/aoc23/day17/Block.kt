package fr.chezbazar.aoc23.day17

class Block(val heatLoss: Int) {
    val heatLossToStart = mutableMapOf<CrucibleLine, Int>()
}