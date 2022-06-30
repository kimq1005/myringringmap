package com.example.mymap.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_Client {

    fun getClient(baseurl:String) : Retrofit{

        val retrofitclient = Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofitclient
    }
}