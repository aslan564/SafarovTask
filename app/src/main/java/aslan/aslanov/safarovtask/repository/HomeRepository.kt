package aslan.aslanov.safarovtask.repository

import aslan.aslanov.safarovtask.model.SafarovModelPOJO
import aslan.aslanov.safarovtask.network.NetworkResult
import aslan.aslanov.safarovtask.network.ServiceVariable.serviceHome
import aslan.aslanov.safarovtask.util.catchServerError
import aslan.aslanov.safarovtask.util.logApp
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
                logApp("2 ${service.errorBody()}")
                catchServerError<SafarovModelPOJO>(service.errorBody()){
                    onComplete(it)
                }
            }

        } catch (e: Exception) {
            logApp("1 $e")
            onComplete(NetworkResult.error(e.message))
        }
    }
}