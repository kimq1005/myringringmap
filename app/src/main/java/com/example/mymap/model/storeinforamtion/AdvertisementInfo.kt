package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class AdvertisementInfo(
    @SerializedName("bannerUrl")
    val bannerUrl: Any,
    @SerializedName("range")
    val range: Any,
    @SerializedName("status")
    val status: String
)