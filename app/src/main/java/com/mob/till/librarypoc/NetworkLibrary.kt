package com.mob.till.librarypoc

import android.content.Context
import org.chromium.net.CronetEngine
import org.chromium.net.UrlRequest
import org.chromium.net.impl.JavaCronetProvider
import java.util.concurrent.Executor
import java.util.concurrent.Executors

const val LOGGER_TAG = "NetworkLibrary LOG :"

class NetworkLibrary {

    fun makeRequest(context: Context) {
        val javaBuilder = JavaCronetProvider(context).createBuilder()
        val cronetEngine: CronetEngine = javaBuilder.build()
        val executor: Executor = Executors.newSingleThreadExecutor()
        val requestBuilder = cronetEngine.newUrlRequestBuilder(
            "http://192.168.178.115:8080/ping",
            MyUrlRequestCallback(),
            executor
        )
        val request: UrlRequest = requestBuilder.build()
        request.start()
    }
}