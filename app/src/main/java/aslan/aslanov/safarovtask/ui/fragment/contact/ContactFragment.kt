package aslan.aslanov.safarovtask.ui.fragment.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.databinding.FragmentContactBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions

class ContactFragment : Fragment() {

    private lateinit var contactViewModel: ContactViewModel
    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        contactViewModel =
            ViewModelProvider(this).get(ContactViewModel::class.java)

        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val supportMapFragment =
            childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment?

        supportMapFragment?.let {
            it.getMapAsync(OnMapReadyCallback { googleMap ->
                googleMap.setOnMapClickListener { latLang ->
                    val markerOption = MarkerOptions()
                    markerOption.position(latLang)
                    markerOption.title("${latLang.latitude} : ${latLang.longitude}")
                    googleMap.clear()
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLang, 13f))
                    googleMap.addMarker(markerOption)
                }
            })
        }

        contactViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}