package com.example.androidact1.viewmodel

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.androidact1.databinding.FragmentMainBinding
import com.example.androidact1.model.FactDataClass
import com.example.androidact1.networking.RetrofitInstance
import retrofit2.Call
import retrofit2.Response

class MainViewModel: ViewModel() {
    private lateinit var binding: FragmentMainBinding
    var button = binding.getFactButton
    var textView = binding.textview
    var spinner = binding.progressBar1
    fun fetchData() {

        spinner.visibility = View.GONE
        button.setOnClickListener {
            spinner.visibility = View.VISIBLE

            RetrofitInstance.apiInterface.getData()
                .enqueue(object : retrofit2.Callback<FactDataClass?> {
                    override fun onResponse(
                        call: Call<FactDataClass?>,
                        response: Response<FactDataClass?>
                    ) {
                        spinner.visibility = View.GONE
                        textView.text = response.body()?.text
                    }

                    override fun onFailure(call: Call<FactDataClass?>, t: Throwable) {
                        spinner.visibility = View.GONE
                    }
                })
        }
    }
}