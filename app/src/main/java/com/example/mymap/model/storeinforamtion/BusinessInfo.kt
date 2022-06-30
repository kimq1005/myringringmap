package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class BusinessInfo(
    @SerializedName("businessClassification")
    val businessClassification: String,
    @SerializedName("businessCondition")
    val businessCondition: String,
    @SerializedName("businessLicenseNumber")
    val businessLicenseNumber: String,
    @SerializedName("businessName")
    val businessName: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("representative")
    val representative: String,
    @SerializedName("taxClassification")
    val taxClassification: String
)