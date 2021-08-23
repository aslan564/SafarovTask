package aslan.aslanov.safarovtask.ui.fragment.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import aslan.aslanov.safarovtask.databinding.FragmentNotificationsBinding
import aslan.aslanov.safarovtask.ui.fragment.notifications.adapter.NotificationAdapter

class NotificationsFragment : Fragment() {

    private val notificationsViewModel by viewModels<NotificationsViewModel>()
    private var _binding: FragmentNotificationsBinding? = null
    private val notificationAdapter by lazy {
        NotificationAdapter {
            Toast.makeText(requireContext(), "${it.title}", Toast.LENGTH_SHORT).show()
        }
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
    }

    private fun bindUI(): Unit = with(binding) {
        notificationsViewModel.addListNotification()
        recyclerViewNotification.adapter = notificationAdapter

        notificationsViewModel.notification.observe(viewLifecycleOwner, Observer {
            it?.let {
                notificationAdapter.submitList(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}