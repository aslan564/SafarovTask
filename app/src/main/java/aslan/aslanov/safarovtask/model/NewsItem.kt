package aslan.aslanov.safarovtask.model


import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json

data class NewsItem(
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
    val tags: List<TagX>?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "type")
    val type: String?
)
class NewsDiffUtil(): DiffUtil.ItemCallback<NewsItem>(){
    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
       return oldItem==newItem
    }

}