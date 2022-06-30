package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("isOpen")
    val isOpen: Boolean,
    @SerializedName("isOrderByPhone")
    val isOrderByPhone: Boolean,
    @SerializedName("nextOpenInfo")
    val nextOpenInfo: String
)