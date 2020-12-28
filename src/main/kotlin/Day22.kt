class Day22(private val input: String) {

    fun solvePart1(): Int {
        return playCombat(false)
    }

    fun solvePart2(): Int {
        return playCombat(true)
    }

    private fun playCombat(recursive: Boolean): Int {
        val (deck1, deck2) = input.split("\n\n").map { it.split("\n").drop(1).map(String::toInt).toMutableList() }
        val (_, deck) = playCombat(deck1, deck2, recursive)
        return deck.reversed().reduceIndexed { index, sum, n -> sum + (index + 1) * n }
    }

    private fun playCombat(startDeck1: List<Int>, startDeck2: List<Int>, recursive: Boolean): Pair<Int, List<Int>> {
        val deck1 = startDeck1.toMutableList()
        val deck2 = startDeck2.toMutableList()

        val history = mutableSetOf<Pair<List<Int>, List<Int>>>()

        while (deck1.isNotEmpty() && deck2.isNotEmpty()) {
            if (recursive && !history.add(deck1 to deck2)) {
                return 1 to deck1
            }

            val card1 = deck1.removeFirst()
            val card2 = deck2.removeFirst()

            val winner = when {
                recursive && deck1.size >= card1 && deck2.size >= card2 -> {
                    playCombat(deck1.take(card1), deck2.take(card2), true).first
                }
                card1 > card2 -> 1
                else -> 2
            }

            if (winner == 1) {
                deck1 += card1
                deck1 += card2
            } else {
                deck2 += card2
                deck2 += card1
            }
        }

        return if (deck1.isNotEmpty()) {
            1 to deck1
        } else {
            2 to deck2
        }
    }
}
