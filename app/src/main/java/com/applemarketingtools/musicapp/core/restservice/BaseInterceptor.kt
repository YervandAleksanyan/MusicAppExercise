package com.applemarketingtools.musicapp.core.restservice

import okhttp3.Interceptor

class BaseInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE)
            .addHeader(CLIENT_DEVICE, DEVICE)
            .build()
        return chain.proceed(request)
    }
}