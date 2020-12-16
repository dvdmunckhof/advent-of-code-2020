fun String.splitOnce(delimiter: String): Pair<String, String> {
    val index = this.indexOf(delimiter)
    if (index == -1) {
        throw IllegalStateException("Delimiter not found")
    }

    val first = this.substring(0, index)
    val second = this.substring(index + delimiter.length)
    return first to second
}
