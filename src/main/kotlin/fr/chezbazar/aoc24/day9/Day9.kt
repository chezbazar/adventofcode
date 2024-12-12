package fr.chezbazar.aoc24.day9

import fr.chezbazar.computeFrom


fun main() {
    computeFrom("aoc24/day9/input.txt") { line ->
        println(checksum(line))
        println(unfragmentedChecksum(line))
    }
}

fun getBlocks(entry: String): Pair<List<Block>, List<Block>> {
    val files = mutableListOf<Block>()
    val freeSpace = mutableListOf<Block>()
    var currentIndex = 0
    entry.forEachIndexed { index, c ->
        val blockSize = c.digitToInt()
        if (blockSize != 0) {
            if (index % 2 == 0) {
                files.add(Block(currentIndex, blockSize, index/2))
            } else {
                freeSpace.add(Block(currentIndex, blockSize))
            }
            currentIndex+= blockSize
        }
    }
    return files to freeSpace
}

fun reorganizeBlocks(files: List<Block>, freeSpace: List<Block>): List<Block> {
    val result = mutableListOf<Block>()
    var currentFileBlock = files.last()
    var currentFileBlockIndex = files.lastIndex
    var currentFreeSpaceBlock = freeSpace.first()
    var currentFreeSpaceBlockIndex = 0
    while (currentFreeSpaceBlock.index < currentFileBlock.index) {
        if (currentFreeSpaceBlock.size == currentFileBlock.size) {
            result.add(Block(currentFreeSpaceBlock.index, currentFreeSpaceBlock.size, currentFileBlock.value))
            currentFileBlockIndex--
            currentFreeSpaceBlockIndex++
            currentFileBlock = files[currentFileBlockIndex]
            currentFreeSpaceBlock = freeSpace[currentFreeSpaceBlockIndex]
        } else if (currentFreeSpaceBlock.size < currentFileBlock.size) {
            result.add(Block(currentFreeSpaceBlock.index, currentFreeSpaceBlock.size, currentFileBlock.value))
            currentFileBlock = Block(currentFileBlock.index, currentFileBlock.size - currentFreeSpaceBlock.size, currentFileBlock.value)
            currentFreeSpaceBlockIndex++
            currentFreeSpaceBlock = freeSpace[currentFreeSpaceBlockIndex]
            if (currentFreeSpaceBlock.index > currentFileBlock.index) {
                result.add(currentFileBlock)
                currentFileBlockIndex--
            }
        } else {
            result.add(Block(currentFreeSpaceBlock.index, currentFileBlock.size, currentFileBlock.value))
            currentFreeSpaceBlock = Block(currentFreeSpaceBlock.index + currentFileBlock.size, currentFreeSpaceBlock.size - currentFileBlock.size)
            currentFileBlockIndex--
            currentFileBlock = files[currentFileBlockIndex]
        }
    }
    for (i in 0..currentFileBlockIndex) {
        result.add(files[i])
    }
    return result
}

fun unfragmentedReorg(files: List<Block>, freeSpace: List<Block>): List<Block> {
    val result = mutableListOf<Block>()
    val workingFreeSpace = freeSpace.toMutableList()
    workingFreeSpace.add(Block(Int.MAX_VALUE, 0))
    for (file in files.reversed()) {
        var currentFreeSpaceIndex = 0
        var fileMoved = false
        while (workingFreeSpace[currentFreeSpaceIndex].index < file.index) {
            if (workingFreeSpace[currentFreeSpaceIndex].size >= file.size) {
                fileMoved = true
                result.add(Block(workingFreeSpace[currentFreeSpaceIndex].index, file.size, file.value))
                workingFreeSpace[currentFreeSpaceIndex] = Block(workingFreeSpace[currentFreeSpaceIndex].index + file.size,
                    workingFreeSpace[currentFreeSpaceIndex].size - file.size)
                currentFreeSpaceIndex = workingFreeSpace.lastIndex
            } else {
                currentFreeSpaceIndex++
            }
        }
        if (!fileMoved) {
            result.add(file)
        }
    }
    return result
}

fun checksum(entry: String): Long {
    val (files, freeSpace) = getBlocks(entry)
    val reorganizedBlocks = reorganizeBlocks(files, freeSpace)
    return reorganizedBlocks.sumOf { it.value.toLong() * (it.index ..<it.index + it.size).sum() }
}

fun unfragmentedChecksum(entry: String): Long {
    val (files, freeSpace) = getBlocks(entry)
    val reorganizedBlocks = unfragmentedReorg(files, freeSpace)
    return reorganizedBlocks.sumOf { it.value.toLong() * (it.index ..<it.index + it.size).sum() }
}

data class Block(val index: Int, val size: Int, val value: Int = 0) {
    fun stringRepresentation() = value.toString().repeat(size)
}