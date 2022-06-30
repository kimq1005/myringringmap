package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class StoreInfo(
    @SerializedName("address")
    val address: String,
    @SerializedName("addressDetail")
    val addressDetail: String,
    @SerializedName("contryOfOrigin")
    val contryOfOrigin: String,
    @SerializedName("description")
    val description: Any,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("photoURL")
    val photoURL: String,
    @SerializedName("postcode")
    val postcode: String
)