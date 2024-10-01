package fr.chezbazar.aoc15.day7

class Assembly {
    val state = mutableMapOf<String, UShort>()

    fun handleInstruction(instruction: String, wireToIgnore: String = "") {
        val (operation, key) = instruction.split(" -> ")
        val operationComponents = operation.split(" ")
        if (key != wireToIgnore) {
            state[key] = when (operationComponents.size) {
                1 -> getValue(operationComponents[0])
                2 -> handleUnaryOperator(operationComponents)
                3 -> handleBinaryOperator(operationComponents)
                else -> throw Exception("Expected 1, 2 or 3 parts, got ${operationComponents.size} in $instruction")
            }
        }
    }

    private fun getValue(value: String): UShort = if (value.toUShortOrNull() != null) {
        value.toUShort()
    } else if (state.containsKey(value)) {
        state[value]!!
    } else {
        throw ParseValueException("Unable to parse value $value")
    }

    private fun handleUnaryOperator(operationComponents: List<String>): UShort {
        val (operator, value) = operationComponents
        return when(operator) {
            "NOT" -> getValue(value).inv()
            else -> throw Exception("Unknown unary operation $operator")
        }
    }

    private fun handleBinaryOperator(operationComponents: List<String>): UShort {
        val (firstOperand, operator, secondOperand) = operationComponents
        return when(operator) {
            "AND" -> getValue(firstOperand) and getValue(secondOperand)
            "OR" -> getValue(firstOperand) or getValue(secondOperand)
            "LSHIFT" -> (getValue(firstOperand).toUInt() shl getValue(secondOperand).toInt()).toUShort()
            "RSHIFT" -> (getValue(firstOperand).toUInt() shr getValue(secondOperand).toInt()).toUShort()
            else -> throw Exception("Unknown binary operation $operator")
        }
    }
}