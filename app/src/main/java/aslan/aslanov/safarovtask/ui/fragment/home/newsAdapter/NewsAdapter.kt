package aslan.aslanov.safarovtask.ui.fragment.home.newsAdapter

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.model.CarouselItem
import aslan.aslanov.safarovtask.model.NewsItem
import aslan.aslanov.safarovtask.util.BaseViewHolder
import aslan.aslanov.safarovtask.util.GenericListAdapter
import aslan.aslanov.safarovtask.util.addImageV
import aslan.aslanov.safarovtask.util.logApp


@SuppressLint("ResourceType")
class NewsAdapter(val onClickNewsListener:(NewsItem)->Unit): GenericListAdapter<NewsItem>(R.layout.layout_news_item,onClickListener = {
    logApp(it.toString())
    onClickNewsListener(it)
})
/*bind = { item: NewsItem, holder: BaseViewHolder, itemCount: Int ->
    with(holder.itemView){
        this.findViewById<TextView>(R.id.text_view_news_date).text= item.date.toString()
        this.findViewById<TextView>(R.id.text_view_news_description).text= item.title.toString()
        this.findViewById<ImageView>(R.id.image_view_news).addImageV(item.image)
    }
},*/