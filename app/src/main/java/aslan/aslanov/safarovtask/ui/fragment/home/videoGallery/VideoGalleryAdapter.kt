package aslan.aslanov.safarovtask.ui.fragment.home.videoGallery

import android.annotation.SuppressLint
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.model.StoriesItem
import aslan.aslanov.safarovtask.model.VideoItem
import aslan.aslanov.safarovtask.util.GenericListAdapter

@SuppressLint("ResourceType")
class VideoGalleryAdapter(private val onClickVideoItem: (VideoItem) -> Unit) :
    GenericListAdapter<VideoItem>(R.layout.layout_video_item, onClickListener = {
        onClickVideoItem(it)
    })