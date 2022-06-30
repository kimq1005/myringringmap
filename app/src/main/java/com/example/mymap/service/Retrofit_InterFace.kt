package com.example.mymap.service

import com.example.mymap.model.library.Library
import com.google.gson.JsonElement
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Retrofit_InterFace {

    @GET("6b684a65456b696d3333794b66704f/json/SeoulPublicLibraryInfo/1/30")
    suspend fun getLibrary(
    ) :Response<Library>
}