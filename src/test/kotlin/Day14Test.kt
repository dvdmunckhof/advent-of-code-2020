import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 14")
class Day14Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("day14_example_part1_input.txt")
        val answer = Day14(input).solvePart1()

        Assertions.assertEquals(165L, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day14_actual_input.txt")
        val answer = Day14(input).solvePart1()

        Assertions.assertEquals(14722016054794L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("day14_example_part2_input.txt")
        val answer = Day14(input).solvePart2()

        Assertions.assertEquals(208L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day14_actual_input.txt")
        val answer = Day14(input).solvePart2()

        Assertions.assertEquals(3618217244644L, answer)
    }
}
