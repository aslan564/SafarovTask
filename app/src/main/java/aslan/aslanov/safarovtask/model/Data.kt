package aslan.aslanov.safarovtask.model


import com.squareup.moshi.Json

data class Data(
    @Json(name = "exportCounts")
    val exportCounts: ExportCounts?,
    @Json(name = "for_entrepreneurs")
    val forEntrepreneurs: ForEntrepreneurs?,
    @Json(name = "karabakh")
    val karabakh: Karabakh?,
    @Json(name = "news")
    val news: News?,
    @Json(name = "pages_on_carousel")
    val pagesOnCarousel: PagesOnCarousel?,
    @Json(name = "stories")
    val stories: Stories?,
    @Json(name = "videos")
    val videos: Videos?
)