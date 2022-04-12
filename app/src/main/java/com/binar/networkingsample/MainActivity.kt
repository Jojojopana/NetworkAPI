package com.binar.networkingsample

import MainAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.binar.networkingsample.data.model.GetAllCarResponseItem
import com.binar.networkingsample.data.network.CarsApi
import com.binar.networkingsample.databinding.ActivityMainBinding
import okhttp3.internal.notifyAll
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        }
    }