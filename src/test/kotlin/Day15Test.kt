import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 15")
class Day15Test {

    private val exampleInput = listOf(0, 3, 6)
    private val actualInput = listOf(2, 1, 10, 11, 0, 6)

    @Test
    fun `Part 1 - Example`() {
        val answer = Day15(exampleInput).solvePart1()

        Assertions.assertEquals(436, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val answer = Day15(actualInput).solvePart1()

        Assertions.assertEquals(232, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val answer = Day15(exampleInput).solvePart2()

        Assertions.assertEquals(175594, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val answer = Day15(actualInput).solvePart2()

        Assertions.assertEquals(18929178, answer)
    }
}
