package aslan.aslanov.safarovtask.util

import android.content.Context
import android.os.Environment
import android.util.Log
import android.widget.ImageView
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.network.NetworkResult
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONObject
import java.io.File
import java.lang.Exception
import java.util.*

//PageItem
private const val TAG = "Utils"
fun logApp(msg: String) {
    Log.d(TAG, "logApp: $msg")
}

fun CircleImageView.addImage(url: String?) {
    url?.let {
        Picasso.get().load(it).placeholder(R.drawable.ic_profile).into(this);
    } ?: Picasso.get().load(R.drawable.ic_profile).into(this);
}

fun ImageView.addImageV(url: String?) {
    url?.let {
        Glide.with(this.context).load(it).placeholder(R.drawable.ic_profile).into(this);
    } ?: Glide.with(this.context).load(R.drawable.ic_profile).into(this);
}

fun getImageFile(context: Context, onComplete: (File) -> Unit) {
    try {
        val fileName = "${UUID.randomUUID()}"
        val storageDirectory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val file=File.createTempFile(
            "JPEG_${fileName}_", /* prefix */
            ".jpg", /* suffix */
            storageDirectory /* directory */
        )
        onComplete(file.absoluteFile)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
fun <T>catchServerError(error: ResponseBody?,onCatchError:(NetworkResult<T>)->Unit){
    try {
        val jOBJError=error?.let {
            JSONObject(it.string())
        }
        jOBJError?.let {
            val messageServer=jOBJError.getString("error")
            val errorServer=jOBJError.getString("message")
            onCatchError(NetworkResult.error(errorServer))
        }

    } catch (e: Exception) {
        onCatchError(NetworkResult.error(e.message))
    }
}

fun getImageFileFromPath(path: String?, onComplete: (File) -> Unit) {
    path?.let {
        val file = File(path)
        onComplete(file)
    }
}