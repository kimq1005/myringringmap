package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class MenuGroup(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("defaultOptionGroups")
    val defaultOptionGroups: List<Any>,
    @SerializedName("description")
    val description: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("isEvent")
    val isEvent: Boolean,
    @SerializedName("isOnlyRingRing")
    val isOnlyRingRing: Boolean,
    @SerializedName("menus")
    val menus: List<Menu>,
    @SerializedName("name")
    val name: String,
    @SerializedName("sortNo")
    val sortNo: Int,
    @SerializedName("store")
    val store: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)