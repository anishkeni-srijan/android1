package com.example.androidact1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
     private val viewModel:MainViewModel by viewModels()

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

    private fun fetchData() {
        lifecycleScope.launch {
            val fact = viewModel.getFact()
            spinner.visibility = View.GONE
            text.text = fact.text
        }

    }
}