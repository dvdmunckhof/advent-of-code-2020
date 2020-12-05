import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 05")
class Day05Test {

    private val exampleInput = listOf("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL")

    @Test
    fun `Sead IDs`() {
        val seatIds = exampleInput.map(Day05::getSeatId)

        Assertions.assertIterableEquals(listOf(567, 119, 820), seatIds)
    }

    @Test
    fun `Part 1 - Example`() {
        val answer = Day05(exampleInput).solvePart1()

        Assertions.assertEquals(820, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day05_input.txt")
        val answer = Day05(input).solvePart1()

        Assertions.assertEquals(801, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day05_input.txt")
        val answer = Day05(input).solvePart2()

        Assertions.assertEquals(597, answer)
    }
}
