package fr.chezbazar.aoc23.day8

import java.util.concurrent.ConcurrentSkipListMap

class Node(val id: String) {
    var left = this
    var right = this

    var leadsToFinish = id == "ZZZ"
    var stepsToFinish = 0

    var ghostStart = id.endsWith('A')
    var ghostFinish = id.endsWith('Z')

    var indexCycle = 0
    var cyclesToFinish = 0
    var allPossibleNodes = mutableListOf<Node>()
    var ghostDestinationComputed = false

    var ghostFinishSteps = if (ghostFinish) mutableSetOf(0) else mutableSetOf()

    var destination = this

    private var jumpMap = ConcurrentSkipListMap<Int, Node>().also { it[0] = this }

    fun setLeftAndRight(left: Node, right: Node) {
        this.left = left
        this.right = right
    }

    fun computeDestination(moves: String) {
        var steps = 0
        var currentNode = this
        moves.forEach {
            steps++
            currentNode = when(it) {
                'R' -> currentNode.right
                else -> currentNode.left
            }
            if (!leadsToFinish && currentNode.id == "ZZZ") {
                leadsToFinish = true
                stepsToFinish = steps
            }
        }
        destination = currentNode
    }

    fun computeGhostDestination(moves: String) {
        if (!ghostDestinationComputed) {
            var steps = 0
            var currentNode = this
            moves.forEach {
                steps++
                currentNode = when (it) {
                    'R' -> currentNode.right
                    else -> currentNode.left
                }
                if (currentNode.ghostFinish) {
                    ghostFinishSteps.add(steps)
                }
            }
            destination = currentNode
            ghostDestinationComputed = true
        }
    }

    fun computeGhostSteps() {
        var currentNode = this
        while (!allPossibleNodes.contains(currentNode)) {
            allPossibleNodes.add(currentNode)
            currentNode = currentNode.destination
        }
        indexCycle = allPossibleNodes.indexOf(currentNode)
        val nodesWithLoop = allPossibleNodes.toMutableList().apply { addAll(allPossibleNodes.subList(indexCycle, allPossibleNodes.size)) }
        allPossibleNodes.forEachIndexed { index, node ->
            node.cyclesToFinish = nodesWithLoop.subList(index, nodesWithLoop.size).indexOfFirst { it != node && it.ghostFinishSteps.isNotEmpty() }
        }
    }

    fun jump(steps: Int): Node = jumpMap.computeIfAbsent(steps) {
        this.jump(steps - 1).destination
    }

}