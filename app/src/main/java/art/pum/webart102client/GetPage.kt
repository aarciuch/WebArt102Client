package art.pum.webart102client

import android.content.Context
import android.util.Log
import androidx.work.*
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class GetPage(ctx: Context, parameters: WorkerParameters) : Worker(ctx, parameters) {
    private val TAG = "GetPage"
    override fun doWork(): Result {
        val url = inputData.getString("URL")

        return try {
            var result : String? = url?.let { uploadPage(it) }
            Log.i(TAG, "doWork success")
            val output : Data = workDataOf("RESULT" to result)
            if (result != null) {
                Log.i(TAG, result)
            }
            Result.success(output)
        } catch (throwable : Throwable) {
            Log.e(TAG, "doWork failure ${throwable.message}")
            Result.failure()
        }
    }

    private fun uploadPage(url: String) : String {
        var s = ""
        Log.i(TAG, url)
        Log.i(TAG, "doWork start working")
        val url1 = URL(url)
        with(url1.openConnection() as HttpsURLConnection) {
            requestMethod = "GET"
            inputStream.bufferedReader().use {
                it.lines().forEach { line ->
                    s+= line
                    s+= '\n'
                }
            }
        }

        return s.substring(0,4095)
    }
}