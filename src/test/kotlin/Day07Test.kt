import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 07")
class Day07Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("day07_example_input.txt")
        val answer = Day07(input).solvePart1("shiny gold")

        Assertions.assertEquals(4, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day07_actual_input.txt")
        val answer = Day07(input).solvePart1("shiny gold")

        Assertions.assertEquals(372, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("day07_example_input.txt")
        val answer = Day07(input).solvePart2("shiny gold")

        Assertions.assertEquals(32, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day07_actual_input.txt")
        val answer = Day07(input).solvePart2("shiny gold")

        Assertions.assertEquals(8015, answer)
    }
}
