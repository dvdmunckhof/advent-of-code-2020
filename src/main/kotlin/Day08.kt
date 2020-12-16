class Day08(input: List<String>) {

    private val program: List<Pair<String, Int>?> = input.map { line ->
        val (operation, arg) = line.splitOnce(" ")
        operation to arg.toInt()
    }

    fun solvePart1(): Int {
        val instructions = ArrayList(program)
        return execute(instructions)
    }

    fun solvePart2(): Int {
        for (i in program.indices) {
            val instructions = ArrayList(program)
            val (operation, arg) = instructions[i]!!
            val instruction = when(operation) {
                "acc" -> continue
                "jmp"-> "nop" to arg
                "nop"-> "jmp" to arg
                else -> error("Unknown operation: $operation")
            }

            instructions[i] = instruction

            val result = execute(instructions)
            if (instructions.last() == null) {
                return result
            }
        }

        error("No solution found")
    }

    private fun execute(instructions: MutableList<Pair<String, Int>?>): Int {
        var index = 0
        var accumulator = 0

        while (index < instructions.size) {
            val (operation, arg) = instructions[index] ?: break
            instructions[index] = null

            if (operation == "jmp") {
                index += arg
                continue
            }

            if (operation == "acc") {
                accumulator += arg
            }

            index++
        }

        return accumulator
    }
}
