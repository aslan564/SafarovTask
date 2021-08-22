package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class TagX(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "title")
    val title: String?
)