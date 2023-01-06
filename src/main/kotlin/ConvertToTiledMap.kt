import java.io.File


fun main() {
    convertToTiledMapFiles()
}

/**
 * Remember to configure the [levelJsPath] and [outputFolder]
 */
fun convertToTiledMapFiles(){
    val levelWidth = 21
    val levelHeight = 13
    val levelJsPath = "/home/jens/Code/2023/jk/Banania/game/level/level.js"
    val outputFolder = "/home/jens/Code/2023/jk/BananiaMapEditor/Tiled/banania/"


    val levelJsLines = File(levelJsPath).readLines()
    val cleanedLevelJsLines = levelJsLines.filter { it.contains("EXTERNAL_LEVELS") }.map {
        it.substringAfter("(").substringBefore(")").ifEmpty {
            ""
        }
    }.filter { it.isNotEmpty() }

    val levelArrays = cleanedLevelJsLines.map { it.split(",") }.chunked(levelWidth)

    val tmxTemplate = """<?xml version="1.0" encoding="UTF-8"?>
<map version="1.9" tiledversion="1.9.1" orientation="orthogonal" renderorder="right-down" width="21" height="13" tilewidth="32" tileheight="32" infinite="0" nextlayerid="2" nextobjectid="1">
 <tileset firstgid="1" source="banania.tsx"/>
 <layer id="1" name="Tile Layer 1" width="21" height="13">
  <data encoding="csv">
DATA
</data>
 </layer>
</map>"""

    levelArrays.forEachIndexed { index, levelData ->
        val data = (0 until levelHeight).joinToString { i ->
            levelData.joinToString { it[i] } + "\n"
        }

        val tmxSource = tmxTemplate.replace("DATA", data)

        File(outputFolder + "level$index.tmx").writeText(tmxSource)
    }
}