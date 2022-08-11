package com.applemarketingtools.musicapp.core.di

import com.applemarketingtools.musicapp.BuildConfig
import com.applemarketingtools.musicapp.core.restservice.BaseInterceptor
import com.applemarketingtools.musicapp.core.restservice.MusicAppRestServiceApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {


    single { getOkHttpClient(baseInterceptor = get()) }

    single { getRetrofit(okHttpClient = get(), baseUrl = BuildConfig.BASE_URL) }

    single { getMusicAppRestService(retrofit = get()) }

    single { BaseInterceptor() }

}

private fun getRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit = Retrofit
    .Builder()
    .baseUrl(baseUrl)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .build()

private fun getMusicAppRestService(retrofit: Retrofit): MusicAppRestServiceApi =
    retrofit.create(MusicAppRestServiceApi::class.java)

private fun getOkHttpClient(
    baseInterceptor: BaseInterceptor,
): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(baseInterceptor)
    .build()


