package aslan.aslanov.safarovtask.repository

import aslan.aslanov.safarovtask.model.SafarovModelPOJO
import aslan.aslanov.safarovtask.network.NetworkResult
import aslan.aslanov.safarovtask.network.ServiceVariable.serviceHome
import java.lang.Exception

class HomeRepository {

    suspend fun getHomeData(onComplete:(NetworkResult<SafarovModelPOJO>)->Unit){
        try {
            val service = serviceHome.getHomeData()
            if (service.isSuccessful) {
                service.body()?.let {
                    onComplete(NetworkResult.success(it))
                }?:onComplete(NetworkResult.error(service.message()))
            }else{
                onComplete(NetworkResult.error(service.message()))
            }

        } catch (e: Exception) {
            onComplete(NetworkResult.error(e.message))
        }
    }
}