package aslan.aslanov.safarovtask.ui.fragment.home.storiesAdapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.model.NewsItem
import aslan.aslanov.safarovtask.model.StoriesDiffUtil
import aslan.aslanov.safarovtask.model.StoriesItem
import aslan.aslanov.safarovtask.util.GenericListAdapter
import aslan.aslanov.safarovtask.util.logApp


@SuppressLint("ResourceType")
class StoriesAdapter(val onClickNewsListener: (StoriesItem) -> Unit) :
    GenericListAdapter<StoriesItem>(R.layout.layout_stories_item, onClickListener = {
        logApp(it.toString())
        onClickNewsListener(it)
    })