class Day04(input: String) {

    private val fieldNames = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    private val entries = input.split("\n\n").map(this::splitEntry)

    fun solvePart1(): Int {
        return entries.count {
            val list = fieldNames.toMutableList()
            list.removeAll(it.keys)
            list.isEmpty()
        }
    }

    fun solvePart2(): Int {
        return entries.count { fields ->
            val list = fieldNames.toMutableList()
            list.removeAll(fields.keys)

            if (list.isNotEmpty()) {
                return@count false
            }

            fields.all { (name, value) -> validateField(name, value) }
        }
    }

    private fun splitEntry(entry: String): Map<String, String> {
        return entry.split(' ', '\n').associate {
            val colonIndex = it.indexOf(':')
            it.substring(0, colonIndex) to it.substring(colonIndex + 1)
        }
    }

    private fun validateField(name: String, value: String): Boolean {
        return when (name) {
            "byr" -> {
                val year = value.toInt()
                year in 1920..2002
            }
            "iyr" -> {
                val year = value.toInt()
                year in 2010..2020
            }
            "eyr" -> {
                val year = value.toInt()
                year in 2020..2030
            }
            "hgt" -> {
                val regex = Regex("^(\\d+)(cm|in)$")
                val result = regex.find(value)
                if (result == null) {
                    false
                } else {
                    val size = result.groupValues[1].toInt()
                    val unit = result.groupValues[2]
                    if (unit == "cm") {
                        size in 150..193
                    } else {
                        size in 59..76
                    }
                }
            }
            "hcl" -> {
                value.matches(Regex("^#[0-9a-z]{6}$"))
            }
            "ecl" -> {
                "amb blu brn gry grn hzl oth".contains(value)
            }
            "pid" -> {
                value.matches(Regex("^\\d{9}$"))
            }
            else -> true
        }
    }
}
