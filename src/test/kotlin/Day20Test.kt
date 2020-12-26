import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 20")
class Day20Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("day20_example_input.txt")
        val answer = Day20(input).solvePart1()

        Assertions.assertEquals(20899048083289L, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("day20_actual_input.txt")
        val answer = Day20(input).solvePart1()

        Assertions.assertEquals(23386616781851L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readString("day20_example_input.txt")
        val answer = Day20(input).solvePart2()

        Assertions.assertEquals(273, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("day20_actual_input.txt")
        val answer = Day20(input).solvePart2()

        Assertions.assertEquals(2376, answer)
    }
}
