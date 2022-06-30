package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class BreakStartTime(
    @SerializedName("hour")
    val hour: Int,
    @SerializedName("minute")
    val minute: Int
)