import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 10")
class Day10Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("day10_example_input.txt").map(String::toInt)
        val answer = Day10(input).solvePart1()

        Assertions.assertEquals(220, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day10_actual_input.txt").map(String::toInt)
        val answer = Day10(input).solvePart1()

        Assertions.assertEquals(2516, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("day10_example_input.txt").map(String::toInt)
        val answer = Day10(input).solvePart2()

        Assertions.assertEquals(19208L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day10_actual_input.txt").map(String::toInt)
        val answer = Day10(input).solvePart2()

        Assertions.assertEquals(296196766695424L, answer)
    }
}
