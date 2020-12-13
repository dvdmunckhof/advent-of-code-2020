class Day13(input: List<String>) {
    private val timestamp = input[0].toInt()
    private val bussIds = input[1].split(',').map(String::toIntOrNull)

    fun solvePart1(): Int {
        return bussIds.filterNotNull()
            .map { id -> id to id - timestamp % id }
            .minByOrNull { it.second }!!
            .let { (bussId, time) -> bussId * time }
    }

    fun solvePart2(): Long {
        val indexedBusses = bussIds.mapIndexedNotNull { index, id -> if (id == null) null else index to id }
        var stepSize = 1L
        var timestamp = 0L

        for ((offset, bussId) in indexedBusses) {
            while ((timestamp + offset) % bussId != 0L) {
                timestamp += stepSize
            }
            stepSize *= bussId
        }

        return timestamp
    }
}
