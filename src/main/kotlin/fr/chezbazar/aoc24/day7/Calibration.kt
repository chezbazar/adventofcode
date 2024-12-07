package fr.chezbazar.aoc24.day7

class Calibration(val result: Long, private val numbers: List<Long>) {
    companion object {
        fun from(entry: String): Calibration {
            val regex = Regex("(\\d+): (.*)")
            val (_, result, numbers) = regex.matchEntire(entry)!!.groupValues
            return Calibration(result.toLong(), numbers.split(" ").map { it.toLong() })
        }
    }

    private fun resultFromOperatorsWithPrecedenceRule(operators: List<Char>): Long {
        val resultList = numbers.toMutableList()
        operators.forEachIndexed { index, op ->
            if (op == '*') {
                resultList[index + 1] *= resultList[index]
                resultList[index] = 0
            }
        }
        return resultList.sum()
    }

    fun isValidWithPrecedenceRule(): Boolean {
        for (operators in operatorsLists(numbers.size - 1)) {
            if (resultFromOperatorsWithPrecedenceRule(operators) == result) {
                showResult(operators)
                return true
            }
        }
        return false
    }

    private fun resultFromOperatorsLeftToRight(operators: List<Char>) = numbers.reduceIndexed { index, acc, l ->
        if (operators[index - 1] == '*') {
            acc * l
        } else if (operators[index - 1] == '|') {
            (acc.toString() + l).toLong()
        } else {
            acc + l
        }
    }

    fun isValidLeftToRight(): Boolean {
        for (operators in operatorsLists(numbers.size - 1)) {
            if (resultFromOperatorsLeftToRight(operators) == result) {
//                showResult(operators)
                return true
            }
        }
        return false
    }

    fun isValidWithConcat(): Boolean {
        for (operators in operatorsListsWithConcat(numbers.size - 1)) {
            if (resultFromOperatorsLeftToRight(operators) == result) {
//                showResult(operators)
                return true
            }
        }
        return false
    }

    private fun operatorsLists(size: Int): List<List<Char>> {
        if (size == 0) {
            return listOf(listOf())
        } else {
            val result = mutableListOf<List<Char>>()
            val smaller = operatorsLists(size - 1)
            for (list in smaller) {
                result.add(list.toMutableList().apply { add('+') })
                result.add(list.toMutableList().apply { add('*') })
            }
            return result
        }
    }

    private fun operatorsListsWithConcat(size: Int): List<List<Char>> {
        if (size == 0) {
            return listOf(listOf())
        } else {
            val result = mutableListOf<List<Char>>()
            val smaller = operatorsListsWithConcat(size - 1)
            for (list in smaller) {
                result.add(list.toMutableList().apply { add('+') })
                result.add(list.toMutableList().apply { add('*') })
                result.add(list.toMutableList().apply { add('|') })
            }
            return result
        }
    }

    private fun showResult(operators: List<Char>) {
        println("$result = ${
            List(2 * numbers.size - 1) { index -> if (index % 2 == 0) numbers[index / 2].toString() else operators[index / 2].toString() }.joinToString(
                " "
            )
        }")
    }
}