package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class WeekInfo(
    @SerializedName("breakEndTime")
    val breakEndTime: BreakEndTime,
    @SerializedName("breakStartTime")
    val breakStartTime: BreakStartTimeXX,
    @SerializedName("closeTime")
    val closeTime: CloseTimeXX,
    @SerializedName("dayOfWeekNum")
    val dayOfWeekNum: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("isBreakTime")
    val isBreakTime: Boolean,
    @SerializedName("isSet")
    val isSet: Boolean,
    @SerializedName("openTime")
    val openTime: OpenTimeX
)