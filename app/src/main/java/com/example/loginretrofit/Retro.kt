package com.example.loginretrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {
    
    fun getRetroClientInstance(): Retrofit{
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.74:9000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}