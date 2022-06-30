package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class OpenInfo(
    @SerializedName("autoOpenCloseInfo")
    val autoOpenCloseInfo: AutoOpenCloseInfo,
    @SerializedName("holidayInfo")
    val holidayInfo: HolidayInfo,
    @SerializedName("isAutoOpen")
    val isAutoOpen: Boolean,
    @SerializedName("openGroup")
    val openGroup: List<OpenGroup>,
    @SerializedName("weekInfo")
    val weekInfo: List<WeekInfo>
)