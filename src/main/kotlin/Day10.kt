class Day10(private val input: List<Int>) {

    fun solvePart1(): Int {
        val joltages = input.toMutableList()
        joltages.add(0) // add wall outlet
        return joltages.sorted().zipWithNext().groupingBy { (a, b) -> b - a }
            .eachCount().values.reduce { acc, value -> acc * (value + 1)}
    }

    fun solvePart2(): Long {
        val joltages = input.sorted()
        val map = mutableMapOf(0 to 1L)
        for (j in joltages) {
            map[j] = (j - 3 until j).mapNotNull(map::get).sum()
        }
        return map.getValue(joltages.last())
    }
}
