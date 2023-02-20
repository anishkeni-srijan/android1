package com.example.androidact1.networking

import com.example.androidact1.model.FactDataClass
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("random.json?language=en")
    fun getData(): Call<FactDataClass>
}