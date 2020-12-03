import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 03")
class Day03Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("day03_example_input.txt")
        val answer = Day03(input).solvePart1()

        Assertions.assertEquals(7, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day03_actual_input.txt")
        val answer = Day03(input).solvePart1()

        Assertions.assertEquals(156, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("day03_example_input.txt")
        val answer = Day03(input).solvePart2()

        Assertions.assertEquals(336, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day03_actual_input.txt")
        val answer = Day03(input).solvePart2()

        Assertions.assertEquals(3521829480, answer)
    }
}
