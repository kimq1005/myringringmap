package com.example.mymap

import com.google.android.gms.maps.model.LatLng

data class LatLngData(
    val id : Long?,
    val latlng : LatLng,
    val tag:String
)