package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class ExportCounts(
    @Json(name = "desc")
    val desc: String?,
    @Json(name = "list")
    val list: List<PageItem>?,
    @Json(name = "title")
    val title: String?
)