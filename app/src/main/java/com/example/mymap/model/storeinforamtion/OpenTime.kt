package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class OpenTime(
    @SerializedName("hour")
    val hour: Int,
    @SerializedName("minute")
    val minute: Int
)