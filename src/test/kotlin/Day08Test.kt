import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 08")
class Day08Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("day08_example_input.txt")
        val answer = Day08(input).solvePart1()

        Assertions.assertEquals(5, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day08_actual_input.txt")
        val answer = Day08(input).solvePart1()

        Assertions.assertEquals(1521, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("day08_example_input.txt")
        val answer = Day08(input).solvePart2()

        Assertions.assertEquals(8, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day08_actual_input.txt")
        val answer = Day08(input).solvePart2()

        Assertions.assertEquals(1016, answer)
    }
}
