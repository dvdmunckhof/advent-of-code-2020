import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 13")
class Day13Test {

    private val exampleInput = listOf("939", "7,13,x,x,59,x,31,19")

    @Test
    fun `Part 1 - Example`() {
        val answer = Day13(exampleInput).solvePart1()

        Assertions.assertEquals(295, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day13_input.txt")
        val answer = Day13(input).solvePart1()

        Assertions.assertEquals(3215, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val answer = Day13(exampleInput).solvePart2()

        Assertions.assertEquals(1068781L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day13_input.txt")
        val answer = Day13(input).solvePart2()

        Assertions.assertEquals(1001569619313439L, answer)
    }
}
