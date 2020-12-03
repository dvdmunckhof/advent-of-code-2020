class Day03(private val grid: List<String>) {

    fun solvePart1(): Long {
        return solveTrees(3, 1)
    }

    fun solvePart2(): Long {
        return solveTrees(1, 1) * solveTrees(3, 1) * solveTrees(5, 1) * solveTrees(7, 1) * solveTrees(1, 2)
    }

    private fun solveTrees(stepX: Int, stepY: Int): Long {
        var trees = 0L
        var x = 0
        var y = 0

        while (y < grid.size) {
            if (grid[y][x] == '#') {
                trees++
            }
            x = (x + stepX) % grid[y].length
            y += stepY
        }

        return trees
    }
}
