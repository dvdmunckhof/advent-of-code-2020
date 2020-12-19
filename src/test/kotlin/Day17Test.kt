import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 17")
class Day17Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("day17_example_input.txt")
        val answer = Day17(input).solvePart1()

        Assertions.assertEquals(112, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day17_actual_input.txt")
        val answer = Day17(input).solvePart1()

        Assertions.assertEquals(401, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("day17_example_input.txt")
        val answer = Day17(input).solvePart2()

        Assertions.assertEquals(848, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day17_actual_input.txt")
        val answer = Day17(input).solvePart2()

        Assertions.assertEquals(2224, answer)
    }
}
