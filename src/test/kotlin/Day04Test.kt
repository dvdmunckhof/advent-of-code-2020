import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 04")
class Day04Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("day04_example_input.txt")
        val answer = Day04(input).solvePart1()

        Assertions.assertEquals(2, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("day04_actual_input.txt")
        val answer = Day04(input).solvePart1()

        Assertions.assertEquals(216, answer)
    }

    @Test
    fun `Part 2 - Example - all valid`() {
        val inputValid = Resources.readString("day04_valid_input.txt")
        val answerValid = Day04(inputValid).solvePart2()

        Assertions.assertEquals(4, answerValid)
    }

    @Test
    fun `Part 2 - Example - all invalid`() {
        val inputInvalid = Resources.readString("day04_invalid_input.txt")
        val answerInvalid = Day04(inputInvalid).solvePart2()

        Assertions.assertEquals(0, answerInvalid)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("day04_actual_input.txt")
        val answer = Day04(input).solvePart2()

        Assertions.assertEquals(150, answer)
    }
}
