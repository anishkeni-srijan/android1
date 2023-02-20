package com.example.androidact1.view

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidact1.R
import com.example.androidact1.databinding.ActivityMainBinding
import com.example.androidact1.databinding.FragmentMainBinding

import com.example.androidact1.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
//    private  lateinit var binding : FragmentMainBinding
//    private  lateinit var mbinding : ActivityMainBinding
    private  lateinit var viewModel: MainViewModel

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    viewModel.fetchData()

}

}
