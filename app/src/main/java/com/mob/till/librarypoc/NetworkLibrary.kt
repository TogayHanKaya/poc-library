package com.mob.till.librarypoc

import android.content.Context
import org.chromium.net.CronetEngine
import org.chromium.net.UrlRequest
import org.chromium.net.impl.JavaCronetProvider
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class NetworkLibrary {

    fun makeRequest(context: Context, callback: Callback) {
        val javaBuilder = JavaCronetProvider(context).createBuilder()
        val cronetEngine: CronetEngine = javaBuilder.build()
        val executor: Executor = Executors.newSingleThreadExecutor()
        val requestBuilder = cronetEngine.newUrlRequestBuilder(
            "http://192.168.178.115:8080/ping",
            MyUrlRequestCallback(callback),
            executor
        )
        val request: UrlRequest = requestBuilder.build()
        request.start()
    }
}