package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class News(
    @Json(name = "all")
    val all: String?,
    @Json(name = "list")
    val list: List<NewsItem>?,
    @Json(name = "title")
    val title: String?
)
