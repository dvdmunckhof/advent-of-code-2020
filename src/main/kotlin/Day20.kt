import kotlin.math.sqrt

class Day20(input: String) {
    private val tiles = input.split("\n\n").map { tile ->
        val id = tile.substring(5, 9).toLong()
        val grid = tile.split("\n").drop(1)
        val edgeLeft = grid.joinToString("") { it.first().toString() }
        val edgeRight = grid.joinToString("") { it.last().toString() }
        Tile(id, grid.first(), edgeRight, grid.last().reversed(), edgeLeft.reversed(), grid.map(String::toList))
    }

    fun solvePart1(): Long {
        return corners().fold(1L) { acc, (tile, _) -> acc * tile.id }
    }

    fun solvePart2(): Int {
        val size = sqrt(tiles.size.toDouble()).toInt()
        val (corner, rotatedCorner) = getUpperLeftCorner()
        val remainingTiles = tiles.toMutableList()
        remainingTiles.remove(corner)

        val imageGrid = List(size) { mutableListOf<Tile>() }
        imageGrid[0] += rotatedCorner

        val orientationTop = 0
        for ((rowPrev, row) in imageGrid.windowed(2)) {
            val targetEdge = rowPrev[0].edgeBottom.reversed()
            val tile = remainingTiles.first { it.edgeSet.contains(targetEdge) }
            val edge = tile.edgeMap.getValue(targetEdge)
            row += tile.transform(orientationTop - edge.orientation, edge.mirrored)
            remainingTiles.remove(tile)
        }

        val orientationLeft = 3
        for (row in imageGrid) {
            for (i in 1 until size) {
                val targetEdge = row.last().edgeRight.reversed()
                val tile = remainingTiles.first { it.edgeSet.contains(targetEdge) }
                val edge = tile.edgeMap.getValue(targetEdge)
                val orientationOffset = if (edge.mirrored) 2 else 0
                row += tile.transform(orientationLeft - edge.orientation + orientationOffset, edge.mirrored)
                remainingTiles.remove(tile)
            }
        }

        val stitchedImage = imageGrid.flatMap { row ->
            row.fold(List(row[0].grid.size - 2) { emptyList<Char>() }) { list, tile ->
                list.zip(tile.grid.drop(1).dropLast(1)) { a, b -> a + b.drop(1).dropLast(1) }
            }
        }

        val transformedImages = (1..7).runningFold(stitchedImage) { image, n ->
            if (n == 4) {
                image.rotate().map(List<Char>::asReversed)
            } else {
                image.rotate()
            }
        }

        val monsterInput = listOf("                  # ", "#    ##    ##    ###", " #  #  #  #  #  #   ")
        val monsterHeight = monsterInput.size
        val monsterWidth = monsterInput[0].length
        val monsterParts = monsterInput.flatMapIndexed { lineIndex: Int, line: String ->
            line.mapIndexedNotNull { charIndex, char -> if (char == '#') lineIndex to charIndex else null }
        }

        val monsterPixels = mutableSetOf<Pair<Int, Int>>()
        for (image in transformedImages) {
            for (row in 0..image.size - monsterHeight) {
                for (col in 0..image[row].size - monsterWidth) {
                    val foundMonster = monsterParts.all { (r, c) -> image[row + r][col + c] == '#' }
                    if (foundMonster) {
                        monsterPixels += monsterParts.map { (r, c) -> row + r to col + c }
                    }
                }
            }

            if (monsterPixels.isNotEmpty()) {
                break
            }
        }
        return stitchedImage.sumBy { row -> row.count { it == '#' } } - monsterPixels.size
    }

    private fun corners(): Sequence<Pair<Tile, List<String>>> {
        return tiles.asSequence().map { tile1 ->
            val otherTiles = tiles.minus(tile1)
            tile1 to tile1.edges.filter { edge -> otherTiles.any { other -> other.edgeSet.contains(edge) } }
        }.filter { it.second.size == 2 }
    }

    private fun getUpperLeftCorner(): Pair<Tile, Tile> {
        val corner = corners().first()
        var rotatedTile = corner.first
        val targetEdges = corner.second.toSet()
        while (!targetEdges.contains(rotatedTile.edgeRight) || !targetEdges.contains(rotatedTile.edgeBottom)) {
            rotatedTile = rotatedTile.rotate()
        }
        return corner.first to rotatedTile
    }

    private class Tile(
        val id: Long,
        val edgeTop: String,
        val edgeRight: String,
        val edgeBottom: String,
        val edgeLeft: String,
        val grid: List<List<Char>>,
    ) {
        val edges = listOf(edgeTop, edgeRight, edgeBottom, edgeLeft)
        val edgeMap = edges.foldIndexed(mapOf<String, Edge>()) { i, map, edge ->
            map + (edge to Edge(i, false)) + (edge.reversed() to Edge(i, true))
        }
        val edgeSet
            get() = edgeMap.keys

        fun transform(rotate: Int, mirror: Boolean): Tile {
            return if (mirror) {
                mirror().rotate(4 - rotate)
            } else {
                rotate(rotate)
            }
        }

        private fun mirror(): Tile {
            val mirroredGrid = grid.map(List<Char>::asReversed)
            return Tile(id, edgeTop.reversed(), edgeLeft.reversed(), edgeBottom.reversed(), edgeRight.reversed(), mirroredGrid)
        }

        fun rotate(rotate: Int = 1): Tile {
            val n = Math.floorMod(rotate, 4)
            return (1..n).fold(this) { t, _ ->
                Tile(t.id, t.edgeLeft, t.edgeTop, t.edgeRight, t.edgeBottom, t.grid.rotate())
            }
        }
    }

    private data class Edge(val orientation: Int, val mirrored: Boolean)

    companion object {
        private fun <T> List<List<T>>.rotate(): List<List<T>> {
            return (0..lastIndex).map { row -> (0..lastIndex).map { col -> this[lastIndex - col][row] } }
        }
    }
}
