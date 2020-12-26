class Day21(input: List<String>) {
    private val foods = input.map { line ->
        val (part1, part2) = line.splitOnce(" (contains ")
        Food(part1.split(" "), part2.dropLast(1).split(", "))
    }

    fun solvePart1(): Int {
        val allergenMap = getAllergenMap()
        val allIngredients = foods.fold(listOf<String>()) { set, food -> set + food.ingredients }
        val remainingIngredients = allergenMap.values.fold(allIngredients) { remainingIngredients, allergenIngredients ->
            remainingIngredients - allergenIngredients
        }
        return remainingIngredients.size
    }

    fun solvePart2(): String {
        val allergens = getAllergenMap().mapValues { it.value.toMutableSet() }
        val ingredientStack = allergens.values.filter { it.size == 1 }.flatten().toMutableList()

        while (ingredientStack.isNotEmpty()) {
            val ingredient = ingredientStack.removeAt(0)
            for (set in allergens.values.filter { it.size > 1 }) {
                set.remove(ingredient)

                if (set.size == 1) {
                    ingredientStack += set.first()
                }
            }
        }

        return allergens.toList().sortedBy { it.first }.joinToString(",") { it.second.first() }
    }

    private fun getAllergenMap(): Map<String, Set<String>> {
        val allergenMap = mutableMapOf<String, Set<String>>()
        for (food in foods) {
            for (allergen in food.allergens) {
                allergenMap[allergen] = if (allergenMap.containsKey(allergen)) {
                    allergenMap.getValue(allergen).intersect(food.ingredients)
                } else {
                    food.ingredients.toSet()
                }
            }
        }
        return allergenMap
    }

    private data class Food(val ingredients: List<String>, val allergens: List<String>)
}
