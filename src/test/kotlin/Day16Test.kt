import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 16")
class Day16Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("day16_example_input.txt")
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(71, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("day16_actual_input.txt")
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(29759, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("day16_actual_input.txt")
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(1307550234719L, answer)
    }
}
