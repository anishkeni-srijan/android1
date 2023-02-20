package com.example.androidact1.service

import com.example.androidact1.model.FactDataClass
import retrofit2.http.GET

interface ApiService {
    @GET("random.json?language=en")
    suspend fun getData(): FactDataClass
}