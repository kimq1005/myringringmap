package com.example.mymap.service

import android.util.Log
import com.example.mymap.Url
import com.example.mymap.Url.Companion.TAG

class Retrofit_Manager {

    companion object {
        val retrofitManager = Retrofit_Manager()
    }


    private var retrofitInterFace = Retrofit_Client.getClient(Url.MAIN_URL).create(Retrofit_InterFace::class.java)


    suspend fun callyeah(){
        val call = retrofitInterFace.getLibrary()

        val body = call.body()
        Log.d(TAG, "callyeah: $body")
    }
}