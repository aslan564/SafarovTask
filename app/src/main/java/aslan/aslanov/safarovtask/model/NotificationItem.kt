package aslan.aslanov.safarovtask.model

import androidx.recyclerview.widget.DiffUtil

data class NotificationItem(
    val id:Int,
    val image:Int,
    val title:String,
    val date:String
)
class NotificationDiffUtil:DiffUtil.ItemCallback<NotificationItem>(){
    override fun areItemsTheSame(oldItem: NotificationItem, newItem: NotificationItem): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: NotificationItem, newItem: NotificationItem): Boolean {
       return oldItem.toString()==newItem.toString()
    }

}
