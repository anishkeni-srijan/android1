package com.example.androidact1

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("random.json?language=en")
    fun getData(): Call<FactDataClass>
}