class Day06(private val input: String) {

    fun solvePart1(): Int {
        return input.split("\n\n").sumBy { it.replace("\n", "").toSet().size }
    }

    fun solvePart2(): Int {
        return input.trim().split("\n\n").sumBy { group ->
            val groupSize = group.count { it == '\n' } + 1
            group.replace("\n", "").groupBy { it }.count { it.value.size == groupSize }
        }
    }
}
