import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 21")
class Day21Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("day21_example_input.txt")
        val answer = Day21(input).solvePart1()

        Assertions.assertEquals(5, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("day21_actual_input.txt")
        val answer = Day21(input).solvePart1()

        Assertions.assertEquals(10L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("day21_example_input.txt")
        val answer = Day21(input).solvePart2()

        Assertions.assertEquals("mxmxvkd,sqjhc,fvjkl", answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("day21_actual_input.txt")
        val answer = Day21(input).solvePart2()

        Assertions.assertEquals("nfnfk,nbgklf,clvr,fttbhdr,qjxxpr,hdsm,sjhds,xchzh", answer)
    }
}
