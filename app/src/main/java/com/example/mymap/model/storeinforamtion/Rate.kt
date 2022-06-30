package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class Rate(
    @SerializedName("amountRate")
    val amountRate: Int,
    @SerializedName("economicalRate")
    val economicalRate: Int,
    @SerializedName("flavorRate")
    val flavorRate: Int,
    @SerializedName("totalRate")
    val totalRate: Int
)