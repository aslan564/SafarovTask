package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class VideoItem(
    @Json(name = "date")
    val date: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "video_url")
    val videoUrl: String?
)