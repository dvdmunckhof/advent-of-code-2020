import kotlin.math.absoluteValue

class Day12(private val input: List<String>) {

    fun solvePart1(initialState: AbsoluteState): Int {
        val finalState = input.fold(initialState) { state, instruction -> state + Instruction(instruction) }
        return manhattanDistance(initialState, finalState)
    }

    fun solvePart2(initialState: WaypointState): Int {
        val finalState = input.fold(initialState) { state, instruction -> state + Instruction(instruction) }
        return manhattanDistance(initialState, finalState)
    }

    class Instruction(line: String) {
        val action = line[0]
        val value = line.substring(1).toInt()
    }

    enum class Direction(val north: Int, val east: Int) {
        NORTH(1, 0), EAST(0, 1), SOUTH(-1, 0), WEST(0, -1);

        operator fun plus(degrees: Int) = values()[Math.floorMod(ordinal + degrees / 90, values().size)]
        operator fun minus(degrees: Int) = plus(-degrees)
    }

    data class AbsoluteState(val direction: Direction, override val north: Int, override val east: Int) : Coordinate {

        operator fun plus(instruction: Instruction): AbsoluteState {
            val value = instruction.value
            return when (instruction.action) {
                'N' -> this.copy(north = north + value)
                'E' -> this.copy(east = east + value)
                'S' -> this.copy(north = north - value)
                'W' -> this.copy(east = east - value)
                'L' -> this.copy(direction = direction - value)
                'R' -> this.copy(direction = direction + value)
                'F' -> this.copy(north = north + (value * direction.north), east = east + (value * direction.east))
                else -> this
            }
        }
    }

    data class WaypointState(override val north: Int, override val east: Int, val wpNorth: Int, val wpEast: Int) : Coordinate {

        operator fun plus(instruction: Instruction): WaypointState {
            val value = instruction.value
            return when (instruction.action) {
                'N' -> this.copy(wpNorth = wpNorth + value)
                'E' -> this.copy(wpEast = wpEast + value)
                'S' -> this.copy(wpNorth = wpNorth - value)
                'W' -> this.copy(wpEast = wpEast - value)
                'L' -> rotate(-value)
                'R' -> rotate(value)
                'F' -> this.copy(north = north + (value * wpNorth), east = east + (value * wpEast))
                else -> this
            }
        }

        private fun rotate(degrees: Int): WaypointState = when (Math.floorMod(degrees, 360)) {
            90 -> copy(wpNorth = -wpEast, wpEast = wpNorth)
            180 -> copy(wpNorth = -wpNorth, wpEast = -wpEast)
            270 -> copy(wpNorth = wpEast, wpEast = -wpNorth)
            else -> this
        }
    }

    private interface Coordinate {
        val north: Int
        val east: Int
    }

    private fun manhattanDistance(c1: Coordinate, c2: Coordinate): Int {
        return (c1.north - c2.north).absoluteValue + (c1.east - c2.east).absoluteValue
    }
}
