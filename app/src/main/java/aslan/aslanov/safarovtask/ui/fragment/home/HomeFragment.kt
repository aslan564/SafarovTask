package aslan.aslanov.safarovtask.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import aslan.aslanov.safarovtask.databinding.FragmentHomeBinding
import aslan.aslanov.safarovtask.ui.fragment.home.caruselAdapter.CarouselAdapter
import aslan.aslanov.safarovtask.ui.fragment.home.entrepreneurs.EntrepreneursAdapter
import aslan.aslanov.safarovtask.ui.fragment.home.newsAdapter.NewsAdapter
import aslan.aslanov.safarovtask.ui.fragment.home.storiesAdapter.StoriesAdapter
import aslan.aslanov.safarovtask.ui.fragment.home.videoGallery.VideoGalleryAdapter
import aslan.aslanov.safarovtask.util.logApp
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val adapterStories by lazy {
        StoriesAdapter {
            logApp(it.toString())
        }
    }
    private val adapterCarousel by lazy {
        CarouselAdapter {
            logApp(it.toString())
        }
    }
    private val adapterNews by lazy {
        NewsAdapter {
            logApp(it.toString())
        }
    }
    private val adapterEntrepreneurs by lazy {
        EntrepreneursAdapter {
            logApp(it.toString())
        }
    }
    private val adapterVideos by lazy {
        VideoGalleryAdapter {
            logApp(it.toString())
        }
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()

    }


    private fun bindUI(): Unit = with(binding) {
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewApplying(linearLayoutManager)

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerViewCarousel)
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (adapterCarousel.itemCount - 1)) {
                    linearLayoutManager.smoothScrollToPosition(recyclerViewCarousel,
                        RecyclerView.State(),
                        linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1)
                } else {
                    linearLayoutManager.smoothScrollToPosition(recyclerViewCarousel,
                        RecyclerView.State(),
                        0)
                }
            }
        }, 0, 3000L)

        homeViewModel.getAllHomeData()

        homeViewModel.model.observe(viewLifecycleOwner, Observer { response ->
            response?.let {
                lifecycleScope.launch {
                    adapterStories.submitList(it.data?.stories?.list)
                    adapterCarousel.submitList(it.data?.pagesOnCarousel?.list)
                    adapterNews.submitList(it.data?.news?.list)
                    adapterEntrepreneurs.submitList(it.data?.forEntrepreneurs?.list)
                    adapterVideos.submitList(it.data?.videos?.list)
                }
                progressBar.visibility = View.GONE
            }
        })

        homeViewModel.error.observe(viewLifecycleOwner, {
            it?.let { message ->
                Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show()
            }
        })
    }

    private fun recyclerViewApplying(
        linearLayoutManager: LinearLayoutManager,
    ): Unit = with(binding) {
        recyclerViewStories.apply {
            adapter = adapterStories
        }
        recyclerViewNews.apply {
            adapter = adapterNews
            // layoutManager=linearLayoutManager
        }
        recyclerViewEntrepreneurs.apply {
            adapter = adapterEntrepreneurs
            // layoutManager=linearLayoutManager
        }
        recyclerViewVideoGallery.apply {
            adapter = adapterVideos
            // layoutManager=linearLayoutManager
        }
        recyclerViewCarousel.apply {
            adapter = adapterCarousel
            layoutManager = linearLayoutManager
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}