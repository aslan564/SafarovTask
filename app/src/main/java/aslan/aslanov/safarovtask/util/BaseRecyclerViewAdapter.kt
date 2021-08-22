package aslan.aslanov.safarovtask.util

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.databinding.*
import aslan.aslanov.safarovtask.model.*

// inline val bind: (item: T, holder: BaseViewHolder, itemCount: Int) -> Unit,
abstract class GenericListAdapter<T : Any>(
    @IdRes val layoutId: Int,
    val onClickListener: (T) -> Unit,
) : ListAdapter<T, BaseViewHolder<T>>(BaseItemCallback<T>()) {

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        //bind(getItem(position), holder, itemCount)
        holder.bind(getItem(position), onClickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return layoutId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val root = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

        return BaseViewHolder.from(parent, viewType)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

}

class BaseViewHolder<T : Any>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: T, onClickListener: (T) -> Unit): Unit = with(binding) {
        when (item) {
            is CarouselItem -> {
                val layout = binding as LayoutCarouselItemBinding
                layout.carouselItem = item
                layout.imageViewCarousel.addImageV(item.image)
                layout.root.setOnClickListener {
                    onClickListener(item)
                }
                executePendingBindings()

            }
            is NewsItem -> {
                val layout = binding as LayoutNewsItemBinding
                layout.newsItem = item
                layout.imageViewNews.addImageV(item.image)
                layout.root.setOnClickListener {
                    onClickListener(item)
                }
                executePendingBindings()
            }
            is StoriesItem -> {
                val layout = binding as LayoutStoriesItemBinding
                layout.imageViewStories.addImageV(item.image)
                layout.root.setOnClickListener {
                    onClickListener(item)
                }
                executePendingBindings()
            }
            is EntrepreneursItem -> {
                val layout = binding as LayoutEntrepreneursItemBinding
                layout.entrepreneursItem = item
                layout.root.setOnClickListener {
                    onClickListener(item)
                }
                executePendingBindings()
            }
            is VideoItem -> {
                val layout = binding as LayoutVideoItemBinding
                layout.videoItem = item
                layout.imageViewVideo.addImageV(item.image)
                layout.root.setOnClickListener {
                    onClickListener(item)
                }
                executePendingBindings()
            }
        }

    }

    companion object {
        fun <T : Any> from(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {

            val inflater = LayoutInflater.from(parent.context)
            val view = when (viewType) {
                R.layout.layout_carousel_item -> {
                    LayoutCarouselItemBinding.inflate(inflater, parent, false)
                }
                R.layout.layout_news_item -> {
                    LayoutNewsItemBinding.inflate(inflater, parent, false)
                }
                R.layout.layout_stories_item -> {
                    LayoutStoriesItemBinding.inflate(inflater, parent, false)
                }
                R.layout.layout_entrepreneurs_item -> {
                    LayoutEntrepreneursItemBinding.inflate(inflater, parent, false)
                }
                R.layout.layout_video_item -> {
                    LayoutVideoItemBinding.inflate(inflater, parent, false)
                }
                else -> {
                    LayoutNewsItemBinding.inflate(inflater, parent, false)
                }
            }
            return BaseViewHolder(view)
        }
    }
}

class BaseItemCallback<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.toString() == newItem.toString()
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

}