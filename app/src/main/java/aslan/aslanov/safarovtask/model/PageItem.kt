package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class PageItem(
    @Json(name = "count")
    val count: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "year")
    val year: String?
)