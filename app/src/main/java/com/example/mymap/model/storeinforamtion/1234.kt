package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class `1234`(
    @SerializedName("advertisement")
    val advertisement: Advertisement,
    @SerializedName("advertisementInfo")
    val advertisementInfo: AdvertisementInfo,
    @SerializedName("automaticCloseInfo")
    val automaticCloseInfo: AutomaticCloseInfo,
    @SerializedName("benefit")
    val benefit: Benefit,
    @SerializedName("businessInfo")
    val businessInfo: BusinessInfo,
    @SerializedName("businessReport")
    val businessReport: BusinessReport,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("isConfirm")
    val isConfirm: String,
    @SerializedName("isDeleted")
    val isDeleted: Boolean,
    @SerializedName("isEvent")
    val isEvent: Boolean,
    @SerializedName("likeUserList")
    val likeUserList: List<Any>,
    @SerializedName("likeUsers")
    val likeUsers: Int,
    @SerializedName("menuGroups")
    val menuGroups: List<MenuGroup>,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("remainingDistance")
    val remainingDistance: Any,
    @SerializedName("setting")
    val setting: Setting,
    @SerializedName("state")
    val state: State,
    @SerializedName("stats")
    val stats: Stats,
    @SerializedName("storeInfo")
    val storeInfo: StoreInfo,
    @SerializedName("updatedAt")
    val updatedAt: String
)