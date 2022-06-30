package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class CloseTime(
    @SerializedName("hour")
    val hour: Int,
    @SerializedName("minute")
    val minute: Int
)