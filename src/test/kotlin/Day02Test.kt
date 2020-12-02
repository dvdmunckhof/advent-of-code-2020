import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 02")
class Day02Test {

    private val exampleInput = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")

    @Test
    fun `Part 1 - Example`() {
        val answer = Day02(exampleInput).solvePart1()

        Assertions.assertEquals(2, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day02_input.txt")
        val answer = Day02(input).solvePart1()

        Assertions.assertEquals(454, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val answer = Day02(exampleInput).solvePart2()

        Assertions.assertEquals(1, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day02_input.txt")
        val answer = Day02(input).solvePart2()

        Assertions.assertEquals(649, answer)
    }
}
