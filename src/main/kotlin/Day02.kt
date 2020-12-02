import java.util.regex.Pattern

class Day02(private val input: List<String>) {

    fun solvePart1(): Int {
        return passwordEntries.count { (range, char, password) ->
            password.count { it == char } in range
        }
    }

    fun solvePart2(): Int {
        return passwordEntries.count { (range, char, password) ->
            (password[range.first - 1] == char) != (password[range.last - 1] == char)
        }
    }

    private val passwordEntries: List<PasswordEntry>
        get() {
            val pattern = Pattern.compile("^(\\d+)-(\\d+) (.): (.+)$")
            return input.map { entry ->
                val matcher = pattern.matcher(entry)
                matcher.matches()
                val min = matcher.group(1).toInt()
                val max = matcher.group(2).toInt()
                val char = matcher.group(3)[0]
                val password = matcher.group(4)
                PasswordEntry(min..max, char, password)
            }
        }

    private data class PasswordEntry(val range: IntRange, val char: Char, val password: String)
}
