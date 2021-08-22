package aslan.aslanov.safarovtask.ui.fragment.profile

import android.Manifest
import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.fragment.findNavController
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.databinding.FragmentProfileBinding
import aslan.aslanov.safarovtask.util.getImageFile
import aslan.aslanov.safarovtask.util.logApp
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import java.io.ByteArrayOutputStream
import java.lang.Exception


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private var selectedImageBytes: ByteArray? = null
    private var path: String? = null
    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                captureImage()
            } else {
                registerLauncher()
            }
        }
    private val requestActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            when (result.resultCode) {
                RESULT_OK -> {

                    val bmOptions=BitmapFactory.Options().apply {
                        inJustDecodeBounds=true
                    }
                   // val selectedImagePath = result.data!!
                   BitmapFactory.decodeFile(path)?.also {
                       binding.imageViewProfile.setImageBitmap(it)
                   }

                }
                RESULT_CANCELED -> {

                }
                else -> {
                }
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
    }

    private fun bindUI(): Unit = with(binding) {
        lifecycleOwner = this@ProfileFragment

        imageViewAdd.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        requireActivity(),
                        Manifest.permission.CAMERA
                    )
                ) {
                    Snackbar.make(requireView(),
                        "Permission needed for camera",
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction("Give Permission") {
                            registerLauncher()
                        }.show()

                } else {
                    registerLauncher()
                }
            } else {
                captureImage()
            }
        }
        textViewPersonalInfo.setOnClickListener {
            val action =
                ProfileFragmentDirections.actionNavigationProfileToNavigationProfileDetails()
            findNavController().navigate(action)
        }
    }

    private fun captureImage() {
        try {
            getImageFile(requireContext()) { imageFile ->
                 path = imageFile.toURI().path

                val fileProvider = FileProvider.getUriForFile(requireContext(),
                    "aslan.aslanov.safarovtask.provider",
                    imageFile)
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                    putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
                }
                requestActivityForResult.launch(intent)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun registerLauncher() {
        val cameraPermission = Manifest.permission.CAMERA
        requestPermission.launch(cameraPermission)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}