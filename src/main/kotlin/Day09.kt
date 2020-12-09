class Day09(private val input: List<Long>) {

    fun solvePart1(preambleSize: Int): Long {
        val buffer = input.take(preambleSize).toMutableList()

        return input.drop(preambleSize).first { number ->
            for ((i, a) in buffer.withIndex()) {
                for (b in buffer.listIterator(i + 1)) {
                    if (a + b == number && a != b) {
                        buffer.removeFirst()
                        buffer.add(number)
                        return@first false
                    }
                }
            }
            true
        }
    }

    fun solvePart2(target: Long): Long {
        for (i in input.indices) {
            var sum = 0L
            var index = i

            while (sum < target) {
                sum += input[index++]
            }

            if (sum == target) {
                val range = input.subList(i, index)
                return range.minOrNull()!! + range.maxOrNull()!!
            }
        }

        error("No solution found")
    }
}
