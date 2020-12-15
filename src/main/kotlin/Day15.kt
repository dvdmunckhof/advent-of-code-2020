class Day15(private val input: List<Int>) {

    fun solvePart1() = memoryGame(2020)

    fun solvePart2() = memoryGame(30000000)

    private fun memoryGame(size: Int): Int {
        val history = input.dropLast(1).withIndex()
            .associateTo(mutableMapOf()) { (index, value) -> value to index + 1 }

        return memoryGame(history, input.last(), input.size, size)
    }

    private tailrec fun memoryGame(history: MutableMap<Int, Int>, number: Int, counter: Int, size: Int): Int {
        val lastIndex = history[number]
        val nextNumber = if (lastIndex == null) 0 else (counter - lastIndex)
        history[number] = counter

        return if (counter == size) {
            number
        } else {
            memoryGame(history, nextNumber, counter + 1, size)
        }
    }
}
