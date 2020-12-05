import java.io.Reader

object Resources {

    fun readString(fileName: String): String {
        return resourceReader(fileName).readText()
    }

    fun readAsList(fileName: String): List<String> {
        return resourceReader(fileName).readLines()
    }

    private fun resourceReader(fileName: String): Reader {
        return javaClass.classLoader.getResourceAsStream(fileName)?.reader()
            ?: throw IllegalArgumentException("Cannot find Resource: $fileName")
    }
}
