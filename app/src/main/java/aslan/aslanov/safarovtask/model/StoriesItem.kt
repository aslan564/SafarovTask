package aslan.aslanov.safarovtask.model


import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json

data class StoriesItem(
    @Json(name = "detail_url")
    val detailUrl: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "title")
    val title: String?
)

class StoriesDiffUtil:DiffUtil.ItemCallback<StoriesItem>(){
    override fun areItemsTheSame(oldItem: StoriesItem, newItem: StoriesItem): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: StoriesItem, newItem: StoriesItem): Boolean {
        return oldItem==newItem
    }

}