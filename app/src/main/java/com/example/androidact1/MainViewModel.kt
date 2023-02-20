package com.example.androidact1

import androidx.lifecycle.ViewModel
import com.example.androidact1.repository.MainRepository
import com.example.androidact1.service.RetrofitBuilder


class MainViewModel: ViewModel() {

    private var repository: MainRepository = MainRepository(RetrofitBuilder.apiInterface)
    suspend fun  getFact() = repository.getFacts()


}