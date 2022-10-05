import java.io.File


fun main() {
    val id = 1
    val level = File("/home/jens/Code/2022/jk/BananiaTiledMap/src/main/kotlin/test.csv").readLines()

    level.forEach {
        //println(it)
    }

  val new =  level.map {
        it.split(",")
    }

  val wow=  (0..20).map {idex->
             val li=   new.map {
                    it.get(idex)
                }

      li
    }

    wow.forEachIndexed { index, strings ->
        println("EXTERNAL_LEVELS[$id][$index] = new Array("+ strings.joinToString { (it.toInt()+1).toString() }+");")
    }

}