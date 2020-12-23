import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 19")
class Day19Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("day19_example_part1_input.txt")
        val answer = Day19(input).solvePart1()

        Assertions.assertEquals(2, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("day19_actual_input.txt")
        val answer = Day19(input).solvePart1()

        Assertions.assertEquals(213, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readString("day19_example_part2_input.txt")
        val answer = Day19(input).solvePart2()

        Assertions.assertEquals(12, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("day19_actual_input.txt")
        val answer = Day19(input).solvePart2()

        Assertions.assertEquals(325, answer)
    }
}
