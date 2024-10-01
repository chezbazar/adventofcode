package fr.chezbazar.aoc15.day2

import fr.chezbazar.computeFrom

fun main() {
    val wrappingPaperAreas = mutableListOf<Int>()
    val ribbonLengths = mutableListOf<Int>()
    computeFrom("/aoc15/day2/input.txt") { line ->
        val (l,w,h) = line.split('x').map { it.toInt() }
        wrappingPaperAreas.add(computeWrappingPaper(l,w,h))
        ribbonLengths.add(computeRibbon(l,w,h))
    }
    println(wrappingPaperAreas.sum())
    println(ribbonLengths.sum())
}

fun computeWrappingPaper(l: Int, w: Int, h: Int) = listOf(l*w, l*h, h*w).let {
    it.min() + 2 * it.sum()
}

fun computeRibbon(l: Int, w:Int, h:Int) = 2 * l + 2 * w + 2 * h + l * h * w - 2 * maxOf(l,w,h)