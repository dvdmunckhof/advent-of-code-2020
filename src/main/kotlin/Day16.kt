class Day16(input: String) {
    private val rules: Map<String, List<IntRange>>
    private val ticket: List<Int>
    private val nearbyTickets: List<List<Int>>

    init {
        val sections = input.split("\n\n")

        rules = sections[0].split('\n').associate { line ->
            val (key, value) = line.splitOnce(": ")
            val ranges = value.split(" or ").map { range ->
                val (from, to) = range.splitOnce("-")
                from.toInt()..to.toInt()
            }
            key to ranges
        }

        ticket = sections[1].substringAfter('\n').split(',').map(String::toInt)
        nearbyTickets = sections[2].split('\n').drop(1).map { line -> line.split(',').map(String::toInt) }
    }

    fun solvePart1(): Int {
        val ranges = rules.values.flatten()
        return nearbyTickets.flatten().filterNot { value -> ranges.contains(value) }.sum()
    }

    fun solvePart2(): Long {
        val flatRanges = rules.values.flatten()
        val validTickets = nearbyTickets.filter { values ->
            values.all { value -> flatRanges.contains(value) }
        }

        val columnMapping = MutableList(ticket.size) { rules.keys.toMutableSet() }

        for (ticket in validTickets) {
            for ((index, value) in ticket.withIndex()) {
                columnMapping[index].removeIf { fieldName -> !rules.getValue(fieldName).contains(value) }
            }
        }

        val columns = columnMapping.sortedBy { it.size }
        for (i in columns.indices) {
            val fieldName = columns[i].first()
            for (nextColumn in columns.listIterator(i + 1)) {
                nextColumn.remove(fieldName)
            }
        }

        return columnMapping.map { it.first() }.mapIndexed { index, field -> field to ticket[index] }
            .filter { (fieldName, _) -> fieldName.startsWith("departure") }
            .fold(1L) { acc, field -> acc * field.second.toLong() }
    }

    private fun List<IntRange>.contains(value: Int): Boolean {
        return this.any { range -> range.contains(value) }
    }
}
