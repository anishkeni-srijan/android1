package com.example.androidact1.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://uselessfacts.jsph.pl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}