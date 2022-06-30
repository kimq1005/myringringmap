package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class Advertisement(
    @SerializedName("endDate")
    val endDate: Any,
    @SerializedName("startDate")
    val startDate: Any
)