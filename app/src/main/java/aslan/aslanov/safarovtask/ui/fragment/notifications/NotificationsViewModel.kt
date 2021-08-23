package aslan.aslanov.safarovtask.ui.fragment.notifications

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.model.NotificationItem
import kotlinx.coroutines.launch

class NotificationsViewModel() : ViewModel() {
    private val text1 =
        " Biznes forumlar kateqoriyasında yeni İnkişaf\n Bankının (AİB) Azərbaycandakı Daimi\n Nümayəndəliyinin rəhbəri başlıqlı post "
    private val text3 = "Siz uğurla İxracatçılar Klubuna Üzv seçildiniz"
    private val date1 = "12 dəqiqə əvvə"
    private var _notification = MutableLiveData<List<NotificationItem>>()
    val notification: LiveData<List<NotificationItem>> = _notification

    fun addListNotification()=viewModelScope.launch {
        val notificationList = ArrayList<NotificationItem>(arrayListOf())
        repeat(11) {
            when {
                it % 2 == 0 -> {
                    notificationList.add(NotificationItem(it, R.drawable.ic_notification, text1, date1))
                }
                it % 3 == 0 -> {
                    notificationList.add(NotificationItem(it, R.drawable.ic_notification_profile, text3, "2 gün əvvəl "))
                }
                else -> {
                    notificationList.add(NotificationItem(it, R.drawable.ic_notification_of, text1, "3 saat əvvəl  "))
                }
            }
        }
        _notification.value=notificationList
    }
}