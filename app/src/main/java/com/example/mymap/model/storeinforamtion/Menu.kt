package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("basePrice")
    val basePrice: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("group")
    val group: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("isDeleted")
    val isDeleted: Boolean,
    @SerializedName("isOnlyRingRing")
    val isOnlyRingRing: Boolean,
    @SerializedName("menuStatus")
    val menuStatus: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("optionGroups")
    val optionGroups: List<Any>,
    @SerializedName("promotionDiscount")
    val promotionDiscount: Int,
    @SerializedName("recommend")
    val recommend: Boolean,
    @SerializedName("recommendCount")
    val recommendCount: Int,
    @SerializedName("reviewCount")
    val reviewCount: Int,
    @SerializedName("salesCount")
    val salesCount: Int,
    @SerializedName("sortNo")
    val sortNo: Int,
    @SerializedName("store")
    val store: String,
    @SerializedName("tags")
    val tags: List<Any>,
    @SerializedName("updatedAt")
    val updatedAt: String
)