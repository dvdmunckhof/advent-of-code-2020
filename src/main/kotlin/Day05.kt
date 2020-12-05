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
            return seat.reversed()
                .map { c -> if (c == 'B' || c == 'R') 1 else 0 }
                .foldIndexed(0) { i, acc, bit -> acc or (bit shl i) }
        }
    }
}
