package com.example.androidact1

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

     lateinit var button:Button
     lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       button = findViewById(R.id.getFactButton)
       text = findViewById(R.id.textview)

        button.setOnClickListener {
            fetchData()
        }
    }

    private fun fetchData(){

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("wait...")
        progressDialog.show()

         RetrofitInstance.apiInterface.getData().enqueue(object : retrofit2.Callback<FactDataClass?> {
            override fun onResponse(
                call: Call<FactDataClass?>,
                response: Response<FactDataClass?>
            ) {
                text.text = response.body()?.text

                progressDialog.dismiss()

            }

            override fun onFailure(call: Call<FactDataClass?>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(this@MainActivity, "${t.localizedMessage}",Toast.LENGTH_SHORT).show()
            }
        })

    }
}