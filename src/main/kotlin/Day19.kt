class Day19(input: String) {
    private val inputRules: List<String>
    private val inputMessages: List<String>

    init {
        val (rules, messages) = input.splitOnce("\n\n")
        inputRules = rules.split("\n")
        inputMessages = messages.split("\n")
    }

    fun solvePart1(): Int {
        val rules = parseRules(inputRules)
        return inputMessages.count { matchRule(rules, it, listOf(0)) }
    }

    fun solvePart2(): Int {
        val updatedRules = listOf("8: 42 | 42 8", "11: 42 31 | 42 11 31")
        val rules = parseRules(inputRules + updatedRules).toSortedMap()
        return inputMessages.count { matchRule(rules, it, listOf(0)) }
    }

    private fun matchRule(rules: Map<Int, Rule>, message: String, stack: List<Int>): Boolean {
        if (stack.isEmpty()) {
            return message.isEmpty()
        }

        return when (val rule = rules.getValue(stack.first())) {
            is Rule.Literal -> message.startsWith(rule.value) && matchRule(rules, message.drop(1), stack.drop(1))
            is Rule.Reference -> rule.groups.any { group -> matchRule(rules, message, group + stack.drop(1)) }
        }
    }

    private fun parseRules(rules: List<String>): Map<Int, Rule> {
        return rules.associate { rule ->
            val (key, value) = rule.splitOnce(": ")
            key.toInt() to if (value.startsWith('"')) {
                Rule.Literal(value.elementAt(1))
            } else {
                Rule.Reference(value.split(" | ").map { it.split(" ").map(String::toInt) })
            }
        }
    }

    sealed class Rule {
        class Literal(val value: Char) : Rule()
        class Reference(val groups: List<List<Int>>) : Rule()
    }
}
