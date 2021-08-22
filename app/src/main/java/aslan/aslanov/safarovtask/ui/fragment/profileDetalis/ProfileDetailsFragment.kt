package aslan.aslanov.safarovtask.ui.fragment.profileDetalis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.databinding.FragmentProfileBinding
import aslan.aslanov.safarovtask.databinding.FragmentProfileDetalisBinding
import aslan.aslanov.safarovtask.ui.activity.MainActivity


class ProfileDetailsFragment : Fragment() {

    private var _binding: FragmentProfileDetalisBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileDetalisBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // (activity as MainActivity).actionBar!!.title="sdfsdfsdf"
        bindUi()
    }

    private fun bindUi(): Unit = with(binding) {
        lifecycleOwner = this@ProfileDetailsFragment
        buttonSave.setOnClickListener {
            val name = editTextName.text.toString()
            val surname = editTextSurname.text.toString()
            val email = editTextEmail.text.toString()
            val phone = editTextPhone.text.toString()
            when {
                name.isEmpty() -> {
                    editTextName.error = "Ad bos ola bilmez"
                }
                surname.isEmpty() -> {
                    editTextSurname.error = "Soyad bos ola bilmez"
                }
                email.isEmpty() -> {
                    editTextEmail.error = "Email bos ola bilmez"
                }
                phone.isEmpty() -> {
                    editTextPhone.error = "Telefon nomresi bos ola bilmez"
                    return@setOnClickListener
                }
                else ->{
                    Toast.makeText(requireContext(),
                        "Melumatlar Yaddasa yazildi",
                        Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }
    }

    companion object {
        private const val TAG = "ProfileDetailsFragment"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}