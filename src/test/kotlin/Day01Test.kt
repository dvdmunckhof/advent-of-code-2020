import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 01")
class Day01Test {

    private val exampleInput = listOf(1721, 979, 366, 299, 675, 1456)

    @Test
    fun `Part 1 - Example`() {
        val answer = Day01(exampleInput).solvePart1()

        Assertions.assertEquals(514_579, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsIntList("day01_input.txt")
        val answer = Day01(input).solvePart1()

        Assertions.assertEquals(876_459, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val answer = Day01(exampleInput).solvePart2()

        Assertions.assertEquals(241_861_950, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsIntList("day01_input.txt")
        val answer = Day01(input).solvePart2()

        Assertions.assertEquals(116_168_640, answer)
    }
}
