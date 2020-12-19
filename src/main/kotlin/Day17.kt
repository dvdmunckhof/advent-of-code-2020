class Day17(private val input: List<String>) {

    fun solvePart1(): Int {
        return runCycles(3)
    }

    fun solvePart2(): Int {
        return runCycles(4)
    }

    private fun runCycles(dimensions: Int): Int {
        val neighbours = (0..80).map { i -> Coordinate(i % 3 - 1, i % 9 / 3 - 1, i % 27 / 9 - 1, i / 27 - 1) }
            .minus(Coordinate(0, 0, 0, 0))
            .filter { dimensions == 4 || it.w == 0 }

        val grid = input.flatMapIndexed { x, line -> line.mapIndexed { y, c -> Coordinate(x, y, 0, 0) to (c == '#') } }
            .toMap(mutableMapOf())

        val sizeX = input.size
        val sizeY = input[0].length
        val sizeZ = 1
        val sizeW = 1

        for (i in 1..6) {
            val offsetW = if (dimensions == 4) i else 0
            val currentGrid = grid.toMap()
            for (x in -i until sizeX + i) {
                for (y in -i until sizeY + i) {
                    for (z in -i until sizeZ + i) {
                        for (w in -offsetW until sizeW + offsetW) {
                            val coordinate = Coordinate(x, y, z, w)
                            val count = neighbours.count { currentGrid.getOrDefault(coordinate + it, false) }
                            grid[coordinate] = if (currentGrid.getOrDefault(coordinate, false)) {
                                count == 2 || count == 3
                            } else {
                                count == 3
                            }
                        }
                    }
                }
            }
        }
        return grid.values.count { it }
    }

    private data class Coordinate(val x: Int, val y: Int, val z: Int, val w: Int) {

        operator fun plus(other: Coordinate): Coordinate {
            return Coordinate(this.x + other.x, this.y + other.y, this.z + other.z, this.w + other.w)
        }
    }
}
