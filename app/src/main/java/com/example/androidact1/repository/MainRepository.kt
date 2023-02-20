package com.example.androidact1.repository

import com.example.androidact1.service.ApiService

class MainRepository(private val apiService: ApiService) {
  suspend fun getFacts() = apiService.getData()
}