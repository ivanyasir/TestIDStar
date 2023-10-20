package com.example.newskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newskotlin.Models.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Request Data from API
        val myApi = RetrofitClient.retrofit.create(InterfaceAPI::class.java)

        val call: Call<ResponseData> = myApi.getData()

        call.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                if (response.isSuccessful) {
                    val data: ResponseData? = response.body()
                    // Handle the data here
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                // Handle network error
            }
        })
    }
}