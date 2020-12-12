import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 11")
class Day11Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("day11_example_input.txt")
        val answer = Day11(input).solvePart1()

        Assertions.assertEquals(37, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day11_actual_input.txt")
        val answer = Day11(input).solvePart1()

        Assertions.assertEquals(2424, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("day11_example_input.txt")
        val answer = Day11(input).solvePart2()

        Assertions.assertEquals(26, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day11_actual_input.txt")
        val answer = Day11(input).solvePart2()

        Assertions.assertEquals(2208, answer)
    }
}
