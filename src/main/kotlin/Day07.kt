import java.util.regex.Pattern
import kotlin.streams.asSequence

class Day07(private val input: List<String>) {

    fun solvePart1(bag: String): Int {
        val bagMap = mutableMapOf<String, MutableList<String>>()

        for (rule in input) {
            val (parent, children) = parseRule(rule)
            for (child in children.keys) {
                bagMap.getOrPut(child, ::mutableListOf) += parent
            }
        }

        val parents = mutableSetOf<String>()
        val queue = bagMap.getValue(bag)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (parents.add(node)) {
                queue += bagMap[node] ?: continue
            }
        }

        return parents.size
    }

    fun solvePart2(bag: String): Int {
        val map = input.map(this::parseRule).associate { it.name to it.children.toList() }
        return countChildBags(bag, map)
    }

    private fun countChildBags(name: String, map: Map<String, List<Pair<String, Int>>>): Int {
        return map.getValue(name).sumBy { (bag, count) -> count + countChildBags(bag, map) * count }
    }

    private fun parseRule(rule: String): BagRule {
        val (name, content) = rule.split(" bags contain ")

        val children = Pattern.compile("(\\d+) (\\w+ \\w+) bag")
            .matcher(content).results().asSequence()
            .associate { it.group(2) to it.group(1).toInt() }

        return BagRule(name, children)
    }

    private data class BagRule(val name: String, val children: Map<String, Int>)
}
