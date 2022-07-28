package com.mob.till.librarypoc

import android.content.Context
import org.chromium.net.CronetEngine
import org.chromium.net.UrlRequest
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class NetworkLibrary(context: Context) {

    val myBuilder = CronetEngine.Builder(context)
    val cronetEngine: CronetEngine = myBuilder.build()
    val executor: Executor = Executors.newSingleThreadExecutor()
    val requestBuilder = cronetEngine.newUrlRequestBuilder(
        "http://192.168.178.115:8080/ping",
        MyUrlRequestCallback(),
        executor
    )

    val request: UrlRequest = requestBuilder.build()

    fun makeRequest() {
        request.start()
    }
}