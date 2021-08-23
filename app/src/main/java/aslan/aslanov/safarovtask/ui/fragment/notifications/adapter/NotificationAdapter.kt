package aslan.aslanov.safarovtask.ui.fragment.notifications.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import aslan.aslanov.safarovtask.model.NotificationDiffUtil
import aslan.aslanov.safarovtask.model.NotificationItem

@SuppressLint("ResourceType")
class NotificationAdapter(private val onClickNotificationItem: (NotificationItem) -> Unit) :
    ListAdapter<NotificationItem,NotificationViewHolder>(NotificationDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
       holder.bind(getItem(position),onClickNotificationItem)
    }

}