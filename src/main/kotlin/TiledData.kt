data class TiledData(

	@Json(name="orientation")
	val orientation: String? = null,

	@Json(name="nextlayerid")
	val nextlayerid: Int? = null,

	@Json(name="renderorder")
	val renderorder: String? = null,

	@Json(name="infinite")
	val infinite: Boolean? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="version")
	val version: String? = null,

	@Json(name="nextobjectid")
	val nextobjectid: Int? = null,

	@Json(name="tilewidth")
	val tilewidth: Int? = null,

	@Json(name="tiledversion")
	val tiledversion: String? = null,

	@Json(name="tileheight")
	val tileheight: Int? = null,

	@Json(name="layers")
	val layers: List<LayersItem?>? = null,

	@Json(name="tilesets")
	val tilesets: List<TilesetsItem?>? = null,

	@Json(name="width")
	val width: Int? = null,

	@Json(name="compressionlevel")
	val compressionlevel: Int? = null,

	@Json(name="height")
	val height: Int? = null
)

data class TilesetsItem(

	@Json(name="firstgid")
	val firstgid: Int? = null,

	@Json(name="source")
	val source: String? = null
)

data class LayersItem(

	@Json(name="visible")
	val visible: Boolean? = null,

	@Json(name="data")
	val data: List<Int?>? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="width")
	val width: Int? = null,

	@Json(name="x")
	val X: Int? = null,

	@Json(name="y")
	val Y: Int? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="opacity")
	val opacity: Int? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="height")
	val height: Int? = null
)

