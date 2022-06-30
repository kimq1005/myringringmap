package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class BusinessReport(
    @SerializedName("address")
    val address: String,
    @SerializedName("form")
    val form: String,
    @SerializedName("representative")
    val representative: String,
    @SerializedName("salesOfficeName")
    val salesOfficeName: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("uniqueNumber")
    val uniqueNumber: String
)