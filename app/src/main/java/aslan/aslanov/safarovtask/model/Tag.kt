package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class Tag(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "title")
    val title: String?
)