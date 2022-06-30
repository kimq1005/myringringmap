package com.example.mymap.model.storeinforamtion


import com.google.gson.annotations.SerializedName

data class HolidayInfo(
    @SerializedName("holidayNotice")
    val holidayNotice: String,
    @SerializedName("isPublicHoliday")
    val isPublicHoliday: Boolean,
    @SerializedName("regularHoliday")
    val regularHoliday: List<Any>,
    @SerializedName("temporaryHoliday")
    val temporaryHoliday: List<Any>
)