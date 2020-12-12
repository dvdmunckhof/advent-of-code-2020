class Day11(input: List<String>) {

    private val directionOffsets = (-1..1).flatMap { a -> (-1..1).map { b -> a to b } }.minus(0 to 0)
    private val inputSeatGrid = input.map { row ->
        row.map {
            when (it) {
                'L' -> false
                '#' -> true
                else -> null
            }
        }
    }

    fun solvePart1(): Int {
        return calculateSeats(inputSeatGrid) { seatGrid: List<List<Boolean?>>, ri: Int, ci: Int, occupied: Boolean ->
            val count = directionOffsets.count { (ro, co) -> seatGrid.getOrNull(ri + ro)?.getOrNull(ci + co) ?: false }

            if (occupied) {
                count < 4
            } else {
                count == 0
            }
        }
    }

    fun solvePart2(): Int {
        val rowIndices = inputSeatGrid.indices
        val columnIndices = inputSeatGrid[0].indices

        return calculateSeats(inputSeatGrid) { seatGrid: List<List<Boolean?>>, rowIndex: Int, columnIndex: Int, occupied: Boolean ->
            val count = directionOffsets.count { (rowOffset, columnOffset) ->
                var r = rowIndex + rowOffset
                var c = columnIndex + columnOffset

                while (r in rowIndices && c in columnIndices) {
                    val seatState = seatGrid[r][c]
                    if (seatState != null) {
                        return@count seatState
                    }

                    r += rowOffset
                    c += columnOffset
                }
                false
            }

            if (occupied) {
                count < 5
            } else {
                count == 0
            }
        }
    }

    private tailrec fun calculateSeats(seatGrid: List<List<Boolean?>>, checkSeat: (seatGrid: List<List<Boolean?>>, ri: Int, si: Int, occupied: Boolean) -> Boolean): Int {
        val newGrid = seatGrid.mapIndexed { rowIndex, row ->
            row.mapIndexed { columnIndex, occupied ->
                if (occupied == null) {
                    null
                } else {
                    checkSeat(seatGrid, rowIndex, columnIndex, occupied)
                }
            }
        }

        return if (seatGrid == newGrid) {
            seatGrid.sumBy { row -> row.count { it == true } }
        } else {
            calculateSeats(newGrid, checkSeat)
        }
    }
}
