package aslan.aslanov.safarovtask.network

import android.os.Build
import aslan.aslanov.safarovtask.BuildConfig
import aslan.aslanov.safarovtask.network.RetrofitFactory.createService
import aslan.aslanov.safarovtask.network.service.HomeService
import aslan.aslanov.safarovtask.util.NetworkConstants.BASE_URL

object ServiceVariable {
    val serviceHome by lazy { createService<HomeService>(BuildConfig.DEBUG,BASE_URL) }
}