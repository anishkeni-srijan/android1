package com.example.androidact1

import android.app.ProgressDialog
import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidact1.databinding.ActivityMainBinding

import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var  binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.getFactButton.setOnClickListener {
            fetchData()
        }
    }

    private fun fetchData(){
        println("here")
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("wait...")
        progressDialog.show()

         RetrofitInstance.apiInterface.getData().enqueue(object : retrofit2.Callback<FactDataClass?> {
            override fun onResponse(
                call: Call<FactDataClass?>,
                response: Response<FactDataClass?>
            ) {
                binding.textview.text = response.body()?.text

                progressDialog.dismiss()

            }

            override fun onFailure(call: Call<FactDataClass?>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(this@MainActivity, "${t.localizedMessage}",Toast.LENGTH_SHORT).show()
            }
        })

    }
}