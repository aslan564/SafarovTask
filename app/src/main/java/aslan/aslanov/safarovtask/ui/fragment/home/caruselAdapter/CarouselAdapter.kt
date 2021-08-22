package aslan.aslanov.safarovtask.ui.fragment.home.caruselAdapter

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.model.CarouselItem
import aslan.aslanov.safarovtask.util.BaseViewHolder
import aslan.aslanov.safarovtask.util.GenericListAdapter
import aslan.aslanov.safarovtask.util.addImageV
import aslan.aslanov.safarovtask.util.logApp

@SuppressLint("ResourceType")
class CarouselAdapter ( val onClickCarouselListener:(CarouselItem)->Unit): GenericListAdapter<CarouselItem>(R.layout.layout_carousel_item,
 onClickListener = {
        logApp(it.toString())
        onClickCarouselListener(it)
    })

/*   bind = { item: CarouselItem, holder: BaseViewHolder, itemCount: Int ->
        with(holder.itemView) {
            this.findViewById<ImageView>(R.id.image_view_carousel).addImageV(item.image)
            this.findViewById<TextView>(R.id.text_view_carousel_header).text = item.title.toString()
            this.findViewById<TextView>(R.id.text_view_carousel_desc).text = item.subtitle.toString()
        }

    },*/