package aslan.aslanov.safarovtask.network.service

import aslan.aslanov.safarovtask.model.SafarovModelPOJO
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {
    @GET("home")
    suspend fun getHomeData(
    ):Response<SafarovModelPOJO>
}