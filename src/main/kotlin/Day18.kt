class Day18(private val input: List<String>) {

    fun solvePart1(): Long {
        return solve(listOf(setOf(Token.Plus, Token.Multiply)))
    }

    fun solvePart2(): Long {
        return solve(listOf(setOf(Token.Plus), setOf(Token.Multiply)))
    }

    private fun solve(operatorPrecedence: List<Set<Token>>): Long {
        return input.map(this::parseExpression)
            .fold(0L) { sum, expression -> sum + solveExpression(expression, operatorPrecedence) }
    }

    private fun parseExpression(expression: String): List<Token> {
        val chars = expression.toList()
        val tokens = mutableListOf<Token>()
        var index = 0

        while (index < chars.size) {
            val token = when (chars[index++]) {
                in '0'..'9' -> {
                    val number = expression.drop(index - 1).takeWhile(Char::isDigit)
                    index += number.lastIndex
                    Token.Number(number.toLong())
                }
                '+' -> Token.Plus
                '*' -> Token.Multiply
                '(' -> Token.ParenthesesOpen
                ')' -> Token.ParenthesesClose
                else -> continue
            }

            tokens.add(token)
        }

        return tokens
    }

    private fun solveExpression(tokens: List<Token>, operatorPrecedence: List<Set<Token>>): Long {
        val list = tokens.toMutableList()

        while (true) {
            val indexClose = list.indexOfOrNull(Token.ParenthesesClose) ?: break
            val indexOpen = list.subList(0, indexClose).lastIndexOf(Token.ParenthesesOpen)
            val group = list.subList(indexOpen, indexClose + 1)
            group.removeFirst() // open parentheses
            group.removeLast() // close parentheses
            val result = solveExpression(group, operatorPrecedence)
            group.clear()
            group.add(Token.Number(result))
        }

        for (operators in operatorPrecedence) {
            while (true) {
                val index = list.indexOfFirst { it in operators } - 1
                if (index < 0) break

                val numberA = list.removeAt(index) as Token.Number
                val operator = list.removeAt(index)
                val numberB = list.removeAt(index) as Token.Number

                val result = if (operator == Token.Multiply) {
                    Token.Number(numberA.value * numberB.value)
                } else {
                    Token.Number(numberA.value + numberB.value)
                }

                list.add(index, result)
            }
        }

        return (list.first() as Token.Number).value
    }

    sealed class Token {
        data class Number(val value: Long) : Token()
        object Plus : Token()
        object Multiply : Token()
        object ParenthesesOpen : Token()
        object ParenthesesClose : Token()
    }

    private fun <T> List<T>.indexOfOrNull(element: T): Int? {
        val index = this.indexOf(element)
        return if (index == -1) null else index
    }
}
