package aslan.aslanov.safarovtask.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import aslan.aslanov.safarovtask.model.SafarovModelPOJO
import aslan.aslanov.safarovtask.network.Status
import aslan.aslanov.safarovtask.repository.HomeRepository
import aslan.aslanov.safarovtask.util.logApp
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = HomeRepository()

    private val _model = MutableLiveData<SafarovModelPOJO>()
    val model: LiveData<SafarovModelPOJO> = _model

    fun getAllHomeData() = viewModelScope.launch {
        repository.getHomeData { res ->
            when (res.status) {
                Status.ERROR -> {
                    res.msg?.let {
                        logApp(it)
                    }
                }
                Status.LOADING -> {
                    logApp("loading")
                }
                Status.SUCCESS -> {
                    res.data?.let {
                        _model.value=it
                        logApp(it.toString())
                    }
                }
            }

        }
    }
}