class Day05(private val input: List<String>) {

    fun solvePart1(): Int {
        return input.maxOf(::getSeatId)
    }

    fun solvePart2(): Int {
        input.map(::getSeatId).sorted().reduce { previous, current ->
            if (previous + 1 == current) {
                current
            } else {
                return previous + 1
            }
        }
        error("No solution found")
    }

    companion object {

        fun getSeatId(seat: String): Int {
            val partRow = seat.substring(0, 7)
            val partColumn = seat.substring(7)
            val row = binarySpacePartition(partRow, 'F', 'B')
            val column = binarySpacePartition(partColumn, 'L', 'R')
            return row * 8 + column
        }

        private fun binarySpacePartition(value: String, low: Char, high: Char): Int {
            var min = 0
            var max = (1 shl value.length) - 1

            for (c in value) {
                val count = max - min + 1 // because the range is inclusive
                val halve = count / 2
                when (c) {
                    low -> max -= halve
                    high -> min += halve
                    else -> error("Invalid char $c in $value")
                }
            }
            return min
        }
    }
}
