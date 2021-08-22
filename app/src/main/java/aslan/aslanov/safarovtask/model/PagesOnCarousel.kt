package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class PagesOnCarousel(
    @Json(name = "list")
    val list: List<CarouselItem>?
)