package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class Videos(
    @Json(name = "all")
    val all: String?,
    @Json(name = "list")
    val list: List<VideoItem>?,
    @Json(name = "title")
    val title: String?
)