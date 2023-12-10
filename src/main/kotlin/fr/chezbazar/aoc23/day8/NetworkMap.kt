package fr.chezbazar.aoc23.day8

class NetworkMap(val moves: String) {
    val network = mutableMapOf<String, Node>()

    fun getNode(id: String) = network[id] ?: Node(id).also { network[id] = it }

    fun handleEntry(entry: String) {
        val regex = Regex("([A-Z0-9]{3}) = \\(([A-Z0-9]{3}), ([A-Z0-9]{3})\\)")
        val (node, left, right) = regex.find(entry)!!.destructured
        getNode(node).setLeftAndRight(getNode(left), getNode(right))
    }

    fun getSteps(): Int {
        network.values.forEach { it.computeDestination(moves) }
        var steps = 0
        var currentNode = network["AAA"]!!
        while (!currentNode.leadsToFinish) {
            steps += moves.length
            currentNode = currentNode.destination
        }
        return steps + currentNode.stepsToFinish
    }

    fun getGhostSteps(): Long {
        network.values.forEach { it.computeGhostDestination(moves) }
        var steps = 0L
        var currentNodes = network.values.filter { it.ghostStart }
        currentNodes.forEach { it.computeGhostSteps() }
        while (currentNodes.map { it.ghostFinishSteps }.reduce { acc, ints -> acc.intersect(ints).toMutableSet() }.isEmpty()) {
            val cycleJump = currentNodes.maxOf { it.cyclesToFinish }
            steps += cycleJump * moves.length
            currentNodes = currentNodes.map { it.jump(cycleJump) }
        }
        return steps + currentNodes.map { it.ghostFinishSteps }.reduce { acc, ints -> acc.intersect(ints).toMutableSet() }.min()
    }
}