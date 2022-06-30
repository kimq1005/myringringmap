package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class AutomaticCloseInfo(
    @SerializedName("closeDay")
    val closeDay: Int,
    @SerializedName("closeMonth")
    val closeMonth: Int,
    @SerializedName("openDay")
    val openDay: Int,
    @SerializedName("openMonth")
    val openMonth: Int
)