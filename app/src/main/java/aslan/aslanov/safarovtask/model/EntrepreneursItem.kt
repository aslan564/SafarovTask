package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class EntrepreneursItem(
    @Json(name = "attendable")
    val attendable: Boolean?,
    @Json(name = "date")
    val date: String?,
    @Json(name = "detail_url")
    val detailUrl: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "tags")
    val tags: List<Tag>?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "type")
    val type: String?
)