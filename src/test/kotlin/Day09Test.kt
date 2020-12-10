import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 09")
class Day09Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsLongList("day09_example_input.txt")
        val answer = Day09(input).solvePart1(5)

        Assertions.assertEquals(127, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsLongList("day09_actual_input.txt")
        val answer = Day09(input).solvePart1(25)

        Assertions.assertEquals(57195069, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsLongList("day09_example_input.txt")
        val answer = Day09(input).solvePart2(127)

        Assertions.assertEquals(62, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsLongList("day09_actual_input.txt")
        val answer = Day09(input).solvePart2(57195069)

        Assertions.assertEquals(7409241, answer)
    }
}
