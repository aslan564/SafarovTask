package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class Stories(
    @Json(name = "list")
    val list: List<StoriesItem>?
)