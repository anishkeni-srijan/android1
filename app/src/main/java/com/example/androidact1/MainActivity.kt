package com.example.androidact1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

     lateinit var button:Button
     lateinit var text: TextView
     lateinit var  spinner: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       button = findViewById(R.id.getFactButton)
       text = findViewById(R.id.textview)
        spinner = findViewById(R.id.progressBar1)

        spinner.visibility = View.GONE
        button.setOnClickListener {
           spinner.visibility = View.VISIBLE
            fetchData()
        }
    }

    private fun fetchData(){

         RetrofitInstance.apiInterface.getData().enqueue(object : retrofit2.Callback<FactDataClass?> {
            override fun onResponse(
                call: Call<FactDataClass?>,
                response: Response<FactDataClass?>
            ) {
               spinner.visibility = View.GONE
                text.text = response.body()?.text



            }

            override fun onFailure(call: Call<FactDataClass?>, t: Throwable) {
                spinner.visibility = View.GONE
                Toast.makeText(this@MainActivity, t.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        })

    }
}