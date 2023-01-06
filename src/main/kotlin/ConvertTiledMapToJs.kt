import java.io.File

/**
 * Remember to configure the [tmxFolder] and [outputFile]
 */
fun main() {

    val tmxFolder = File("PATH_TO_TMX_FILES_FOLDER")
    val tmxFiles = tmxFolder.listFiles()?.filter { it.isFile && it.extension == "tmx" }?.sortedBy {
        val index = it.name.substringAfter("level").substringBefore(".").toInt()
        index
    } ?: emptyList()


    val outputFile = File("PATH_TO_BANANIA_LEVEL_JS")

    var source = "var EXTERNAL_LEVELS = new Array();\n\n"

    tmxFiles.forEach { file ->
        val index = file.name.substringAfter("level").substringBefore(".").toInt()
        source += convertTiledMapToJs(file.path, index) + "\n\n"
    }

    outputFile.writeText(source)
}

fun convertTiledMapToJs(filePath: String, levelId: Int): String {
    val height = 21
    val tmxData = File(filePath).readText()
    val levelData =
        tmxData.substringAfter("\"csv\">\n").substringBefore("\n</data>").replace("\n", "").replace(" ", "").split(",")
            .chunked(height)

    val transformedMapData = (0 until height).map { idex ->
        val mapRowData = levelData.map {
            it[idex]
        }

        mapRowData
    }

    val source = transformedMapData.mapIndexed { index, strings ->
        "EXTERNAL_LEVELS[$levelId][$index] = new Array(" + strings.joinToString(",") { (it.toInt() + 0).toString() } + ");"
    }

    return "EXTERNAL_LEVELS[$levelId] = new Array();\n" + source.joinToString("\n") { it }

}