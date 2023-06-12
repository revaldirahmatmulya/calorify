package com.revaldi.calorify.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://calorify-dot-calorify-388602.et.r.appspot.com/"

    private const val BASE_URL_NEWS = "https://saurav.tech/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val retrofitNews: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_NEWS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiEndpoints by lazy {
        retrofit.create(ApiEndpoints::class.java)
    }
}