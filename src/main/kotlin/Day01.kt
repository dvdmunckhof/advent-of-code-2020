@Suppress("ReplaceRangeToWithUntil")
class Day01(private val input: List<Int>) {
    private val lastIndex = input.lastIndex

    fun solvePart1(): Int {
        for (i in 0..lastIndex - 1) {
            for (j in i + 1..lastIndex) {
                val a = input[i]
                val b = input[j]

                if (a + b == 2020) {
                    return a * b
                }
            }
        }
        error("No solution found")
    }

    fun solvePart2(): Int {
        for (i in 0..lastIndex - 2) {
            for (j in i + 1..lastIndex - 1) {
                val a = input[i]
                val b = input[j]
                if (a + b >= 2020) {
                    continue
                }

                for (k in j + 1..lastIndex) {
                    val c = input[k]
                    if (a + b + c == 2020) {
                        return a * b * c
                    }
                }
            }
        }
        error("No solution found")
    }
}
