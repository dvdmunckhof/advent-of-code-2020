class Day14(private val input: List<String>) {

    fun solvePart1(): Long {
        val memory = mutableMapOf<Long, Long>()
        runProgram { index, value, maskZeroes, maskOnes, _ ->
            memory[index] = value and maskZeroes or maskOnes
        }
        return memory.values.sum()
    }

    fun solvePart2(): Long {
        val memory = mutableMapOf<Long, Long>()
        runProgram { index, value, _, maskOnes, floatingBitIndices ->
            val possibilities = 1 shl floatingBitIndices.size // 2^size
            for (floatingBits in 0 until possibilities) {
                val maskedIndex = floatingBitIndices.foldIndexed(index) { valueBitIndex, maskedIndex, floatingBitIndex ->
                    val bitSet = (floatingBits shr valueBitIndex and 1) == 1
                    if (bitSet) {
                        1L shl floatingBitIndex or maskedIndex
                    } else {
                        (1L shl floatingBitIndex).inv() and maskedIndex
                    }
                }
                memory[maskedIndex or maskOnes] = value
            }
        }
        return memory.values.sum()
    }

    private fun runProgram(callback: (index: Long, value: Long, maskZeroes: Long, maskOnes: Long, floatingBits: List<Int>) -> Unit) {
        var maskZeroes = 0L
        var maskOnes = 0L
        var floatingBits = emptyList<Int>()

        for (line in input) {
            if (line.startsWith("mask")) {
                val mask = line.substring(7)
                maskZeroes = mask.replace('X', '1').toLong(2)
                maskOnes = mask.replace('X', '0').toLong(2)
                floatingBits = mask.reversed().withIndex().filter { it.value == 'X' }.map { it.index }
            } else {
                // parse: "mem[xxx] = xxxxxxxx"
                val parts = line.substring(4).split("] = ")
                val index = parts[0].toLong()
                val value = parts[1].toLong()
                callback(index, value, maskZeroes, maskOnes, floatingBits)
            }
        }
    }
}
