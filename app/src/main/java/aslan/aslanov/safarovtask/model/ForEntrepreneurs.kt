package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class ForEntrepreneurs(
    @Json(name = "all")
    val all: String?,
    @Json(name = "list")
    val list: List<EntrepreneursItem>?,
    @Json(name = "title")
    val title: String?
)