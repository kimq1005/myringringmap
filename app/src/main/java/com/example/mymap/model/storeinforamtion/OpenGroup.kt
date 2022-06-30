package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class OpenGroup(
    @SerializedName("breakEndTime")
    val breakEndTime: BreakEndTime,
    @SerializedName("breakStartTime")
    val breakStartTime: BreakStartTime,
    @SerializedName("closeTime")
    val closeTime: CloseTimeX,
    @SerializedName("dayOfWeekCheck")
    val dayOfWeekCheck: List<Boolean>,
    @SerializedName("_id")
    val id: String,
    @SerializedName("isBreakTime")
    val isBreakTime: Boolean,
    @SerializedName("openTime")
    val openTime: OpenTime
)