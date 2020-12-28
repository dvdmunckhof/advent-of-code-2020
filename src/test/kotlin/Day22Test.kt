import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 22")
class Day22Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("day22_example_input.txt")
        val answer = Day22(input).solvePart1()

        Assertions.assertEquals(306, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("day22_actual_input.txt")
        val answer = Day22(input).solvePart1()

        Assertions.assertEquals(31754, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readString("day22_example_input.txt")
        val answer = Day22(input).solvePart2()

        Assertions.assertEquals(291, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("day22_actual_input.txt")
        val answer = Day22(input).solvePart2()

        Assertions.assertEquals(35436, answer)
    }
}
