package com.example.filmography.data.network

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
            .header("X-API-KEY", "5JQ729J-WG4ME2T-M3YDV2R-8H22NE4")
            .method(original.method, original.body)
            .build()
        return chain.proceed(request)
    }
}

