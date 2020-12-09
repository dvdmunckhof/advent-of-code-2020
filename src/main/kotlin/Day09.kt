class Day09(private val input: List<Long>) {

    fun solvePart1(preambleSize: Int): Long {
        return input.windowed(preambleSize + 1).first {
            val number = it.last()
            val buffer = it.dropLast(0)

            for ((i, a) in buffer.withIndex()) {
                for (b in buffer.listIterator(i + 1)) {
                    if (a + b == number && a != b) {
                        return@first false
                    }
                }
            }
            true
        }.last()
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
