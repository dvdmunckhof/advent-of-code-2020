import Day12.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 12")
class Day12Test {

    private val exampleInput = listOf("F10", "N3", "F7", "R90", "F11")
    private val statePart1 = AbsoluteState(Direction.EAST, 0, 0)
    private val statePart2 = WaypointState(0, 0, 1, 10)

    @Test
    fun `Part 1 - Example`() {
        val answer = Day12(exampleInput).solvePart1(statePart1)

        Assertions.assertEquals(25, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day12_input.txt")
        val answer = Day12(input).solvePart1(statePart1)

        Assertions.assertEquals(1645, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val answer = Day12(exampleInput).solvePart2(statePart2)

        Assertions.assertEquals(286, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day12_input.txt")
        val answer = Day12(input).solvePart2(statePart2)

        Assertions.assertEquals(35292, answer)
    }
}
