package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class Setting(
    @SerializedName("breakEndTime")
    val breakEndTime: BreakEndTime,
    @SerializedName("breakStartTime")
    val breakStartTime: BreakStartTime,
    @SerializedName("closeTime")
    val closeTime: CloseTime,
    @SerializedName("isAvailablePickUp")
    val isAvailablePickUp: Boolean,
    @SerializedName("isProgramAutoOpen")
    val isProgramAutoOpen: Boolean,
    @SerializedName("minimumReservationMinute")
    val minimumReservationMinute: Int,
    @SerializedName("openInfo")
    val openInfo: OpenInfo,
    @SerializedName("openTime")
    val openTime: OpenTimeXX,
    @SerializedName("workingDayOfWeek")
    val workingDayOfWeek: List<Boolean>
)