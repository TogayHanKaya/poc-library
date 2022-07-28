package com.mob.till.librarypoc

import android.content.Context
import android.util.Log
import com.google.android.gms.net.CronetProviderInstaller
import org.chromium.net.CronetEngine
import org.chromium.net.UrlRequest
import java.util.concurrent.Executor
import java.util.concurrent.Executors

const val LOGGER_TAG = "NetworkLibrary LOG :"

class NetworkLibrary {

    fun makeRequest(context: Context) {
        CronetProviderInstaller.installProvider(context).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.i(LOGGER_TAG, "Successfully installed Play Services provider: $it")
                val myBuilder = CronetEngine.Builder(context)
                val cronetEngine: CronetEngine = myBuilder.build()
                val executor: Executor = Executors.newSingleThreadExecutor()
                val requestBuilder = cronetEngine.newUrlRequestBuilder(
                    "http://192.168.178.115:8080/ping",
                    MyUrlRequestCallback(),
                    executor
                )
                val request: UrlRequest = requestBuilder.build()
                request.start()
            } else {
                Log.w(LOGGER_TAG, "Unable to load Cronet from Play Services", it.exception)
            }
        }



    }
}