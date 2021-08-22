package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class Karabakh(
    @Json(name = "description")
    val description: Any?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "link")
    val link: String?,
    @Json(name = "title")
    val title: String?
)