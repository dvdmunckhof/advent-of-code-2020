import java.util.regex.Pattern

class Day19(private val input: String) {

    fun solvePart1(): Int {
        val (rules, messages) = input.splitOnce("\n\n")
        val regex = getPattern(rules, "0")
        return messages.split("\n").count { regex.matcher(it).matches() }
    }

    fun solvePart2(): Int {
        error("No solution found")
    }

    private fun getPattern(rules: String, root: String): Pattern {
        val inputRules = rules.split('\n').associate { it.splitOnce(": ") }
        val rulesCache = mutableMapOf<String, String>()

        fun getRule(name: String): String = rulesCache.getOrPut(name) {
            val parts = inputRules.getValue(name).split(' ')
            val containsOr = parts.contains("|")
            buildString {
                if (containsOr) append("(")
                for (part in parts) {
                    val result = when {
                        part == "|" -> "|"
                        part.startsWith("\"") -> part.trim('"')
                        else -> getRule(part)
                    }
                    append(result)
                }
                if (containsOr) append(")")
            }
        }

        return Pattern.compile("^" + getRule(root) + "$")
    }
}
