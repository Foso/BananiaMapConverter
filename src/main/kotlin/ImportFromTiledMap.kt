import java.io.File


fun main() {
    val level = File("/home/jens/Code/2022/Banania/game/level/level.js").readLines()
    val lev = level.filter { it.contains("EXTERNAL_LEVELS") }.map {
        val text=  it.substringAfter("(").substringBefore(")")
        text.ifEmpty {
            ""
        }
        text
    }.filter { it.isNotEmpty() }


    val newL = lev.map { it.split(",") }.chunked(21)

    val template = """<?xml version="1.0" encoding="UTF-8"?>
<map version="1.9" tiledversion="1.9.1" orientation="orthogonal" renderorder="right-down" width="21" height="13" tilewidth="32" tileheight="32" infinite="0" nextlayerid="2" nextobjectid="1">
 <tileset firstgid="1" source="banania.tsx"/>
 <layer id="1" name="Tile Layer 1" width="21" height="13">
  <data encoding="csv">
DATA
</data>
 </layer>
</map>"""



    newL.forEachIndexed { index, lists ->

        val data = (0..12).joinToString { i->

            val test2 = lists.joinToString { it[i].toString() }
            test2+"\n"

        }

        val text= template.replace("DATA",data)

        File("/home/jens/Code/2022/Tiled/level$index.tmx").writeText(text)

    }

}