package aslan.aslanov.safarovtask.model


import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json

data class CarouselItem(
    @Json(name = "detail_url") val detailUrl: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "image") val image: String?,
    @Json(name = "subtitle") val subtitle: String?,
    @Json(name = "title") val title: String?,
    @Json(name = "type") val type: String?,
)

class CarouselDiffUtil:DiffUtil.ItemCallback<CarouselItem>(){
    override fun areItemsTheSame(oldItem: CarouselItem, newItem: CarouselItem): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: CarouselItem, newItem: CarouselItem): Boolean {
       return oldItem==newItem
    }

}