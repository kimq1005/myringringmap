package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class Benefit(
    @SerializedName("item")
    val item: Any,
    @SerializedName("status")
    val status: Boolean
)