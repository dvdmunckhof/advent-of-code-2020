import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 18")
class Day18Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("day18_example_input.txt")
        val answer = Day18(input).solvePart1()

        Assertions.assertEquals(26386L, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day18_actual_input.txt")
        val answer = Day18(input).solvePart1()

        Assertions.assertEquals(98621258158412L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("day18_example_input.txt")
        val answer = Day18(input).solvePart2()

        Assertions.assertEquals(693942L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day18_actual_input.txt")
        val answer = Day18(input).solvePart2()

        Assertions.assertEquals(241216538527890L, answer)
    }
}
