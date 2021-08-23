package aslan.aslanov.safarovtask.ui.fragment.notifications.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import aslan.aslanov.safarovtask.databinding.LayoutNotificationItemBinding
import aslan.aslanov.safarovtask.model.NotificationItem

class NotificationViewHolder(private val binding: LayoutNotificationItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: NotificationItem, onClickNotificationItem: (NotificationItem) -> Unit): Unit =
        with(binding) {
            notificationItem = item
            executePendingBindings()
            imageViewNotification.setImageResource(item.image)
            root.setOnClickListener { onClickNotificationItem(item) }
        }

    companion object {
        fun from(parent: ViewGroup): NotificationViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val root = LayoutNotificationItemBinding.inflate(inflater, parent, false)
            return NotificationViewHolder(root)
        }
    }
}