package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("ownerReviewCount")
    val ownerReviewCount: Int,
    @SerializedName("rate")
    val rate: Rate,
    @SerializedName("reviewCount")
    val reviewCount: Int
)