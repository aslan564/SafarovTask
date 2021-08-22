package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class SafarovModelPOJO(
    @Json(name = "data")
    val `data`: Data?
)

